#include <string>
#include <iostream>
class PrintJob{
public:
	int number;
	std::string filename;
	PrintJob* next;
	PrintJob(){
		next = NULL;
	}
	PrintJob(std::string newName, int newInt){
		filename = newName;
		number = newInt;
		next = NULL;
	}
};
class CharStack{
private:
	char *stackArray;
	int capacity;
	int top;
public:
	~CharStack(){ delete[] stackArray; }

	CharStack(int newCapacity){
		this->capacity = newCapacity;
		stackArray = new char[capacity];
		top = 0;
	}
	void CharStack::push(char newValue){
		if (top == capacity)throw CharStack::Overflow();
		else{
			stackArray[top] = newValue;
			++top;
		}
	}

	bool CharStack::isEmpty() const{
		if (!top)
			return true;
		else
			return false;
	}

	void CharStack::pop(char& newValue){
		if (isEmpty()) throw CharStack::Underflow();
		else{
			top--;
			newValue = stackArray[top];
		}
	}

	//Stack Exceptions
	class Overflow{};
	class Underflow{};
};

class PrintQueue{
public:
	PrintJob* firstMember;
	PrintQueue(){
		firstMember = NULL;
	}
	~PrintQueue(){
		delete firstMember;
	}
	void enqueue(std::string filename, int page){
		if (firstMember == NULL){
			firstMember = new PrintJob(filename, page);
		}
		else if (firstMember->next == NULL){
			if (firstMember->number > page){
				firstMember->next = new PrintJob(filename, page);
			}
			else{
				firstMember->next = new PrintJob(firstMember->filename, firstMember->number);
				firstMember->filename = filename;
				firstMember->number = page;
			}
		}
		else{
			if (page > firstMember->number){
				PrintJob* temp = firstMember->next;
				firstMember->next = new PrintJob(firstMember->filename, firstMember->number);
				firstMember->next->next = temp;
				firstMember->filename = filename;
				firstMember->number = page;
			}
			else{
				PrintJob* previous = firstMember;
				PrintJob* current = firstMember->next;
				while (current->next != NULL && page < current->number){
					previous = current;
					current = current->next;
				}
				if (current->next == NULL){
					if (page < current->number){
						current->next = new PrintJob(filename, page);
					}
					else{
						previous->next = new PrintJob(filename, page);
						previous->next->next = current;
					}
				}
				else{
					previous->next = new PrintJob(filename, page);
					previous->next->next = current;
				}
			}
		}
	}

	PrintJob* dequeue(){
		if (!isEmpty()){
			PrintJob* current = firstMember;
			PrintJob* previous = NULL;
			while (current->next != NULL){
				current = current->next;
				if (previous == NULL){
					previous = firstMember;
				}
				else{
					previous = previous->next;
				}
			}
			PrintJob* newJob = new PrintJob(current->filename, current->number);
			if (previous != NULL)
				previous->next = NULL;
			else
				firstMember = NULL;
			return newJob;
		}
		else{
			std::cout << "The queue is empty!";
		}
	}
	bool isEmpty(){
		if (firstMember == NULL)
			return true;
		else
			return false;
	}
};

#include <iostream>
class TreeNode{
public:
	int value;
	TreeNode *left;
	TreeNode *right;
	TreeNode *next;

	TreeNode(int input){
		value = input;
		left = NULL;
		right = NULL;
	}
};

class NodeQueue{
private:
	TreeNode *front, *rear;

public:
	NodeQueue(){
		front = rear = NULL;
	}
	bool isEmpty(){
		return (front == NULL);
	}
	void enqueue(TreeNode* newNode){
		newNode->next = NULL;
		if (front == NULL){
			front = rear = newNode;
		}
		else{
			rear->next = newNode;
			rear = newNode;
		}
	}
	TreeNode* dequeue(){
		TreeNode* tempNode = front;
		front = front->next;
		return tempNode;
	}
};
#include <string>
#include <iostream>
#include <iomanip>

bool isPalindrome(std::string);

int main(){
	/* Testing queue:
	PrintQueue mainQueue;
	mainQueue.enqueue("Lab Report", 2);
	mainQueue.enqueue("Thesis", 30);
	mainQueue.enqueue("BLARGH", 10);
	mainQueue.enqueue("grump", 54);
	mainQueue.enqueue("hi", 100);
	mainQueue.enqueue("bye", 1);
	mainQueue.enqueue("asdf", 1000);
	mainQueue.enqueue("asdfkjas", 0);
	while (!mainQueue.isEmpty()){
		PrintJob* temp = mainQueue.dequeue();
		std::cout << temp->number << " " << temp->filename<< std::endl;
	}
	*/
}
//Task 1:
bool isPalindrome(std::string newString){
	int length = newString.length();
	char* charArray;
	char* copyArray;
	CharStack* newStack = new CharStack(length);
	charArray = new char[length];
	copyArray = new char[length];
	for (int i = 0; i < length; ++i){
		charArray[i] = newString[i];
	}
	for (int i = 0; i < length; ++i){
		newStack->push(charArray[i]);
	}
	for (int i = 0; i < length; ++i){
		newStack->pop(copyArray[i]);
	}
	for (int i = 0; i < length; ++i){
		if (charArray[i] != copyArray[i]){
			return false;
		}
	}
	return true;

}
