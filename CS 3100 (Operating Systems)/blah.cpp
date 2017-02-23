#include <iostream>
#include <chrono>
#include <thread>
#include <string>
#include <random>
#include <cmath>
#include <unistd.h> //for using sleep function

int main() {
std::default_random_engine generator;
std::normal_distribution<double> distribution(50, 10);
while(true) {
	for (int i = 0; i < 10; ++i) {
	double number = distribution(generator);
	sleep(2);
	std::cout << number << " removed from queue by thread " << i;
}
}
}
