#include <iostream>
#include "TreeNode.cpp"
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