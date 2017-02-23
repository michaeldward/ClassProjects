#include <iostream>
#include "WordTable.cpp"
#include <fstream>


int main(){
	WordTable* hashMap = new WordTable(1024);
	std::ifstream fin;
	std::cout << "Enter filename: ";
	std::string filename;
	std::cin >> filename;
	fin.open(filename);
	std::string word;
	if (!fin.fail()){
		std::cout << "Opening file...\n";
		while (!fin.eof()){
			std::cout << "Reading word...\n";
			std::getline(fin, word);
			hashMap->add(word);
		}
	}
	else{
		std::cout << "Failed to open file...\n";
	}
	WordRecord* newArray = hashMap->getEntries();
	std::cout << hashMap->returnSize();
	for (int i = 0; i < hashMap->returnSize(); ++i){
		std::cout << newArray[i].word << " " << newArray[i].frequency << "\n";
	}
}