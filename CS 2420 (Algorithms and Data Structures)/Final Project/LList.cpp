#include <iostream>
#include "Node.cpp"

class LList
{
public:
	Node *head;
	LList() { head = NULL; } //constructor for empty linked list
	LList(std::string newData) { head = new Node(newData); } //constructor for one word
	void append(std::string newData, int num) //adds a word to linked list if not already found
	{
		Node *newNode = new Node(newData);
		Node *temp = head;
		if (temp == NULL) { //word not found in linked list
			head = newNode;
			head->docNo[head->size++] = num;
		}
		while (temp != NULL) { //increments through linked list
			if (temp->data == newData) { //tests to see if word is already found
				if (temp->docNo[temp->size - 1] != num) {
					temp->docNo[temp->size++] = num; //adds new word to linked list
				}
				return;
			}
			if (temp->next == NULL) { //word not found in linked list
				temp->next = newNode;
				newNode->docNo[newNode->size++] = num; //adds new word to linked list
				return;
			}
			temp = temp->next; //increments to next word in linked list
		}
	}
	int* searchFor(std::string query) { //searches for word within linked list
		Node *temp = head;
		while (temp != NULL) {
			if (temp->data == query) {
				return temp->docNo;
			}
			temp = temp->next;
		}
		int notFound = -1; //returns -1 if word is not found
		return &notFound;
	}
	int returnSize(std::string query) { //returns the size of the array of docNos for the word
		Node *temp = head;
		while (temp != NULL) {
			if (temp->data == query) {
				return temp->size;
			}
			temp = temp->next;
		}
		return -1;
	}
	void print() //prints linked list; used for testing purposes
	{
		Node *temp = head;

		while (temp != NULL)
		{

			if (temp->data != "")
			{
				std::cout << temp->data << " ";
				for (int i = 0; i < temp->size; ++i) {
					std::cout << temp->docNo[i] << " ";
				}
				std::cout << "\n";
			}
			temp = temp->next;
		}
	}//end print function
};//end LList class