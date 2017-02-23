/***************************************************************************************************
*	Michael Ward
*	CS 2420 with Dr. Kyumin Lee
*	Assignment 4 - Hash Tables
*	Description: this assignment reads in a text file from the user and sorts the data based on the
*	hash function specified in the assignment instructions. The data is entered into a size-128 hash
*	table and then the words and their frequency are outputted to the console.
***************************************************************************************************/


#include <iostream>
#include <string>
#include <fstream>

class LLNode {
public:
	LLNode* next;
	std::string value;
	int freq = 1;
	LLNode(std::string);
};

LLNode::LLNode(std::string newValue) {
	value = newValue;
	next = NULL;
}

class LList {
public:
	LLNode* first;
	LList(std::string);
	LList();
	void add(std::string);
	void display();
};

LList::LList() {
	first = NULL;
}

LList::LList(std::string newValue) {
	first = new LLNode(newValue);
}

void LList::add(std::string newValue) {
	LLNode* ptr = this->first;
	if (ptr == NULL) {
		this->first = new LLNode(newValue);
	}
	else {
		while (ptr != NULL) {
			if (ptr->value == newValue) {
				ptr->freq += 1;
				return;
			}
			if (ptr->next == NULL) {
				ptr->next = new LLNode(newValue);
				return;
			}
			ptr = ptr->next;
		}
	}
}

void LList::display() {
	LLNode* ptr = this->first;
	while (ptr != NULL) {
		std::cout << ptr->value << " " << ptr->freq << std::endl;
		ptr = ptr->next;
	}
}

class Hash {
public:
	LList hashes[128];
	void addWord(std::string);
	int computeHash(std::string);
	void display();
};

int Hash::computeHash(std::string newWord) {
	int result = 0;
	for (unsigned int i = 0; i < newWord.length(); ++i) {
		result += (int)newWord[i];
	}
	return result % 128;
}

void Hash::addWord(std::string newWord) {
	int bucket = computeHash(newWord);
	hashes[bucket].add(newWord);
}

void Hash::display() {
	for (int i = 0; i < 127; ++i) {
		//std::cout << "Hash " << i << std::endl; //for testing
		hashes[i].display();
	}
}

void readFromFile(std::string filename) {
	std::ifstream fin;
	fin.open(filename);
	if (fin.fail()) {
		std::cout << "Invalid username." << std::endl;
	}
	else {
		Hash *list = new Hash();
		std::string temp;
		while (!fin.eof()) {
			std::getline(fin, temp);
			list->addWord(temp);
		}
		list->display();
	}
}

int main() {
	std::cout << "Enter filename: ";
	std::string filename;
	std::cin >> filename;
	readFromFile(filename);
}
