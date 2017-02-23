#include <fstream>
#include <sstream>
#include <string>
#include "HTable.cpp"

std::string* readInStop(std::string filename, int& stopSize) { //reads in stop words and stores in array
	std::string *stopWords = new std::string[100];
	std::ifstream stopFile;
	stopFile.open(filename);
	stopSize = 0;
	std::string tempword;
	while (!stopFile.eof()) {
		stopFile >> tempword;
		stopWords[stopSize++] = tempword;
	}
	stopFile.close();
	return stopWords;
}

bool checkWord(std::string word, std::string* stopWords, int stopSize) { //returns false if word is stop word
	if (word[0] == '<') {
		return false;
	}
	for (int i = 0; i < stopSize; ++i) {
		if (stopWords[i] == word ) {
			return false;
		}
	}
	return true;
}


void readIn(std::string filename, int docNum, HashTable* words) { //reads in a document and sorts the words into the specified hash table
	int stopSize = 0;
	std::string *stopWords;
	stopWords = readInStop("D:\stopwords.txt", stopSize);
	std::ifstream file;
	file.open(filename);
	std::string tempWord;

	while (!file.eof())
	{
		file >> tempWord;
		if (checkWord(tempWord, stopWords, stopSize)) {
			words->append(tempWord, docNum);
		}
	}

	//words->print();

	file.close();
}



int* searchQuery(std::string query, HashTable* words, int &arrSize) { //returns array of docNos that query word is found in 
	int key = words->findKey(query);
	//std::cout << key << std::endl;
	int* docResult;
	arrSize = words->table[key].returnSize(query);
	//std::cout << arrSize << std::endl;
	docResult = words->table[key].searchFor(query);
	return docResult;
	/*
	//std::cout << query << ": ";
	if (arrSize == -1) {
		std::cout << "NOT FOUND\n";
	}
	else {
		for (int i = 0; i < arrSize; ++i) {
			std::cout << docResult[i] << " ";
		}
		std::cout << "\n";
	}
	*/
}

void add(int* arr, int &size, int num) { //checks to see if number is already in array and if not, adds to end of array
	for (int i = 0; i < size; ++i) {
		if (arr[i] < num) { //array number smaller than new number
			continue;
		}
		else if (arr[i] == num) { //array number equal to new number
			return;
		}
		else if (arr[i] > num) { //array number greater than new number
			++size;
			for (int j = size; j > i; --j) {
				arr[j] = arr[j - 1];
			}	
			arr[i] = num;
			return;
		}
	}
	arr[size++] = num;
}

void userInput(std::string &word1, std::string &word2, int &command) { //takes in user input and analyzes
	std::cout << "Enter search query: ";
	std::string userQuery;
	std::getline(std::cin, userQuery);
	std::istringstream iss(userQuery);
	std::string words[100];
	int place = 0;
	while (iss) { //take in user's input
		iss >> words[place];
		place++;
	}
	word1 = words[0];
	word2 = words[2];
	if (words[1] == "and" || words[1] == "And" || words[1] == "AND" || words[1] == "ANd" || words[1] == "AnD" || words[1] == "anD" || words[1] == "aND" || words[1] == "aNd") { //because we can
		command = 1;
	}
	else if (words[1] == "or" || words[1] == "OR" || words[1] == "Or" || words[1] == "oR") {
		command = 2;
	}
}

int* userQuery(HashTable* table, int &resultSize) {
	int command = 0;
	std::string word1, word2;
	//userInput(word1, word2, command);
	std::cout << "Enter search query: ";
	std::string userQuery;
	std::getline(std::cin, userQuery);
	std::istringstream iss(userQuery);
	std::string words[100];
	int place = 0;
	while (iss) {
		iss >> words[place];
		place++;
	}
	word1 = words[0];
	word2 = words[2];
	if (words[1] == "and" || words[1] == "And" || words[1] == "AND" || words[1] == "ANd" || words[1] == "AnD" || words[1] == "anD" || words[1] == "aND" || words[1] == "aNd") { //because we can
		command = 1;
	}
	else if (words[1] == "or" || words[1] == "OR" || words[1] == "Or" || words[1] == "oR") {
		command = 2;
	}


	//std::cout << word1 << std::endl << word2 << std::endl << command << std::endl;

	int size1 = 0, size2 = 0;
	int *arr1 = searchQuery(word1, table, size1); //returns array of documents word is found in and sets size1
	int *arr2;
	int result[50] = { NULL }; //result array will hold documents that match query
	if (command == 0) { //only one word
		resultSize = size1;
		for (int i = 0; i < resultSize; ++i) {
			result[i] = arr1[i];
		}
	}
	else {
		arr2 = searchQuery(word2, table, size2); //returns array of documents word is found in and sets size2
		if (command == 1) { //AND query
			for (int i = 0; i < size1; ++i) { //loops through first result array
				for (int j = 0; j < size2; ++j) { //loops through second result array
					if (arr1[i] == arr2[j]) {
						result[resultSize++] = arr1[i];
						//std::cout << arr1[i] << std::endl << arr2[j] << std::endl << result[resultSize - 1] << std::endl;
					}
				}
			}
		} else { //OR query
			for (int i = 0; i < size1; ++i) { //loops through first result array
				add(result, resultSize, arr1[i]);
			}
			for (int j = 0; j < size2; ++j) { //loops through second result array
				add(result, resultSize, arr2[j]); //adds to array and checks for duplication
			}
		}
	}

	return result;
}



int main()
{
	std::string docLocation = "C:\\Users\\Michael\\Desktop\\Project\\Documents\\"; //change to location of documents on your computer
	HashTable* hash = new HashTable(); //create hash table
	 for (int i = 1; i < 10; ++i) { //read in docs 1 - 9
		std::string s = std::to_string(i);
		readIn(docLocation + "cranfield000" + s, i, hash);
	}
	for (int i = 10; i < 51; ++i) { //read in docs 10 - 50
		std::string s = std::to_string(i);
		readIn( docLocation + "cranfield00" + s, i, hash);
	}

	while (true) {
		int resultSize = 0;
		int *result = userQuery(hash, resultSize);
		if (result[0] == NULL) { //word not found
			std::cout << "NOT FOUND";
		}
		else {
			for (int i = 0; i < resultSize; ++i) { //prints docNos that word was found in
				std::cout << "Doc" << result[i];
				if (i < resultSize - 1) {
					std::cout << ", ";
				}
			}
		}
		std::cout << std::endl << std::endl;
	}
}