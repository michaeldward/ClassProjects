#include "WordRecord.cpp"

class WordTable{
private:
	int key;
	int value;
	int size;
	WordRecord** entries;
	WordRecord* head;
public:
	int getKey(){ return key; }
	int getValue(){ return value; }
	WordTable(int newKey, int newValue){
		this->key = newKey;
		this->value = newValue;
	}
	WordTable(int N){
		size = N;
		entries = new WordRecord*[size];
		head = entries[0];
		for (int i = 0; i < size; ++i){
			entries[i] = NULL;
		}
	}
	~WordTable(){
		delete entries;
	}

	void add(std::string str){
		int h = hash(str, size);
		bool done = false;
		WordRecord *temp = entries[h];
		if (temp == NULL){
			temp = new WordRecord(str);
		}
		while (temp->next != NULL && !done){
			if (temp->word == str){
				++temp->frequency;
				done = true;
			}
			temp = temp->next;
		}
		if (!done){
			WordRecord* newRecord = new WordRecord();
			temp->next = newRecord;
			newRecord->word = str;
			newRecord->frequency = 1;
		}
	}

	int hash(std::string s, int n)
	{
		int hash = 5381 % n;
		for (int i = 0; i < s.length(); i++)
			hash = (hash * 33 + s[i]) % n;
		return hash;
	}
	WordRecord *getEntries(){
		WordRecord* tempArray = new WordRecord[returnSize()];
		return tempArray;
	}
	int returnSize(){
		int newSize = 0, cursor = 0;
		for (int n = 0; n < size; ++n){
			newSize += listSize(entries[n]);
		}
		return newSize;
	}
	int listSize(WordRecord *cursor){
		int newSize = 0;
		while (cursor != NULL){
			newSize++;
			cursor = cursor->next;
		}
		return newSize;
	}
	void listCopy(WordRecord* ptr, WordRecord array[], int &cursor){
		while (ptr != NULL){
			array[cursor] = *ptr;
			++cursor;
			ptr = ptr->next;
		}
	}
};