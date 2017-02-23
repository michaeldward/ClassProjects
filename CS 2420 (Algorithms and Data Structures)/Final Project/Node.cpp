#include <string>
const int TOTALDOCS = 50;
class Node
{
public:
	Node *next; //ptr to next word for linked list
	std::string data; //word
	int docNo[TOTALDOCS]; //array containg docNos word is found in 
	int size = 0; //size of array

	Node(std::string newData)
	{
		data = newData;
		next = NULL;
	}
};