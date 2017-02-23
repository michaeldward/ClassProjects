#include <iostream>
#include <fstream>
#include <cmath>
#include <string>

const int SIZE = 30;
int values[SIZE];
int owner[SIZE];
int bestOwner[SIZE];
int totalValue = 0;
int minDifference = -1;
void readIn(std::string);
void binaryValues(int);
void computeBinary(int, int);
void testValue(int);
void outputAnswer(int);


int main(){
	std::string filename;
	std::cout << "Enter a filename: ";
	std::getline(std::cin, filename);
	readIn(filename);

}

void readIn(std::string filename){
	int size;
	std::ifstream fin;
	fin.open(filename);
	fin >> size;
	for (int n = 0; n < size; ++n){
		fin >> values[n];
		totalValue += values[n];
	}
	for (int n = size; n < SIZE; ++n){
		values[n] = -1;
		owner[n] = -1;
	}
	binaryValues(size);
}

void binaryValues(int size){
	for (int n = 0; n < SIZE; ++n){
		if (n < size){
			owner[n] = 0;
		}
		else{
			owner[n] = -1;
		}
	}
	testValue(size);
	computeBinary(size, 0);
	outputAnswer(size);
}

void computeBinary(int size, int cursor){
	if (cursor < size - 1){
		++cursor;
		computeBinary(size, cursor);
		--cursor;
	}
	if (owner[cursor] == 0){ //check to see if value is 0
		owner[cursor] = 1;
		testValue(size); //print permutation
	}
	else{
		owner[cursor] = 0;
		testValue(size);
	}
	if (cursor < size - 1){
		++cursor; //deincrement cursor
		computeBinary(size, cursor);
		--cursor;
	}
	
}

void testValue(int size){
	int aliceValue = 0;
	int bobValue = 0;
	int difference = -1;
	//test 
	/*
	for (int n = 0; n < size; ++n){
		std::cout << owner[n];
	}
	*/
	for (int n = 0; n < size; ++n){
		if (owner[n] == 0)
			aliceValue += values[n];
		else if (owner[n] == 1)
			bobValue += values[n];
		else
			break;
	}
	difference = std::abs(aliceValue - bobValue);
	if (minDifference == -1){
		minDifference = difference;
	}
	if (difference < minDifference){
		minDifference = difference;
		for (int n = 0; n < size; ++n){
			bestOwner[n] = owner[n];
		}
	}
}

void outputAnswer(int size){
	int aliceValue = 0;
	int bobValue = 0;
	for (int n = 0; n < size; ++n){
		if (bestOwner[n] == 0)
			aliceValue += values[n];
		else if (bestOwner[n] == 1)
			bobValue += values[n];
		else
			break;
	}
	std::cout << "Difference: " << minDifference << std::endl;
	std::cout << "Alice values: ";
	for (int n = 0; n < size; ++n){
		if (bestOwner[n] == 0){
			std::cout << values[n] << " ";
		}
	}
	std::cout << std::endl << "Alice total: " << aliceValue << std::endl;
	std::cout << "Bob values: ";
	for (int n = 0; n < size; ++n){
		if (bestOwner[n] == 1){
			std::cout << values[n] << " ";
		}
	}
	std::cout << std::endl << "Bob total: " << bobValue << std::endl;

}