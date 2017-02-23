#include <iostream>
#include <chrono>
#include <thread>
#include <string>
#include <random>
#include <cmath>
#include <unistd.h> //for using sleep function
#include <mutex>

class Queue {
private:
	int* content;
	int position;
	int size; 
public:
	Queue(int);
	void pushBack(int);
	int pop();
	//~Queue();
};

Queue::Queue(int newSize) {
	position = 0;
	size = newSize;
	if (size > 0) {
		content = new int[size];
	}
}
/*
Queue::~Queue() {
	delete[] content;
}
*/

void Queue::pushBack(int element) {
	if (position < size) {
		content[position] = element;
		position += 1;
	}
}

int Queue::pop() {
	return content[--position];
}


void call_producer(Queue &queue, std::mutex& queue_mutex, std::default_random_engine& generator, std::normal_distribution<double> distribution, int this_id) {
	while(true) {	
		double number = 0;
		do {
			number = distribution(generator);
		} while (number > 100 || number < 1);
		queue_mutex.lock();
		queue.pushBack(number);
		//std::cout << number << " added to queue by " << this_id << std::endl;
		queue_mutex.unlock();
		std::this_thread::sleep_for(std::chrono::milliseconds(1000));
	}
 }

 void call_consumer(Queue &queue, int this_id, std::mutex& cout_mutex, std::mutex& queue_mutex) {
 	while(true) {
 		std::this_thread::sleep_for(std::chrono::milliseconds(2000));
 		queue_mutex.lock();
 		int result = queue.pop();
 		queue_mutex.unlock();
 		cout_mutex.lock();
 		std::cout << result << " removed from queue by thread " <<  this_id << std::endl;
 		cout_mutex.unlock();
 	}
 }

int main(int argc, char *argv[]) {
	std::mutex cout_mutex; //mutex for console out printing
	std::mutex queue_mutex; //mutex for access to the queue
	//Launch a thread
	if (argc > 3) {
		if(isdigit(*argv[1]) && isdigit(*argv[2]) && isdigit(*argv[3])) {
			int num_of_producers = std::stoi(argv[1]);
			int num_of_consumers = std::stoi(argv[2]);
			if(num_of_consumers < 2 * num_of_producers) {
				int size_of_queue = std::stoi(argv[3]);
				std::thread* producers = new std::thread[num_of_producers];
				std::thread* consumers = new std::thread[num_of_consumers];
				Queue queue(size_of_queue);
				std::default_random_engine generator;
				std::normal_distribution<double> distribution(50, 10);
				for (int i = 0; i < num_of_producers; ++i) {
					producers[i] = std::thread (call_producer, std::ref(queue), std::ref(queue_mutex), std::ref(generator), std::ref(distribution), i + 1);
					std::this_thread::sleep_for(std::chrono::milliseconds(200));
				}
				for (int i = 0; i < num_of_consumers; ++i) {	
					consumers[i] = std::thread (call_consumer, std::ref(queue), i + 1, std::ref(cout_mutex), std::ref(queue_mutex));
					std::this_thread::sleep_for(std::chrono::milliseconds(400));
				}
				//Join the thread with the main thread
				for (int i = 0; i < num_of_producers; ++i) {
					producers[i].join();
				}
				for (int i = 0; i < num_of_consumers; ++i) {
					consumers[i].join();
				}
			} else { //too many consumers
				std::cout << "Too many consumers are entered. The producers will not fill the shared queue fast enough for all the consumers.\n";
			}
		} else { //one argument is not a number
			std::cout << "Invalid input: please enter numbers.\n";
		}
	} else { //not enough arguments
		std::cout << "Invalid input: please enter at least three arguments.\n";
	}
	return 0;
}