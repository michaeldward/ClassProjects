#include <string>

class WordRecord{
public:
	std::string word;
	int frequency;
	WordRecord* next;

	WordRecord(){
		next = NULL;
		frequency = 1;
	}
	WordRecord(WordRecord* newNext){
		next = newNext;
		frequency = 1;
	}
	WordRecord(std::string newName){
		word = newName;
		frequency = 1;
		next = NULL;
	}

};
