#include "LList.cpp"

class HashTable //document data structure
{
public:
	LList table[521]; //creates hash table of linked lists with size of 521
	int findKey(std::string newData)//hash function; takes in word and returns hash value
	{
		int asciiValue = 0;
		for (int i = 0; i < (int)newData.length(); ++i) //adds ascii values of all letters in the word
		{
			asciiValue += (int)newData[i];
		}
		return asciiValue % 521; //mods result by the size of the hash table
	}

	void append(std::string newData, int docNo) //adds a new word to the table
	{
		int index = findKey(newData); //finds hash key
		table[index].append(newData, docNo); //inserts word (if not found) into the proper bucket
	}

	void print() //prints hash table; used for testing purposes only
	{
		for (int i = 0; i < 127; ++i)
		{
			table[i].print();
		}
	}
};