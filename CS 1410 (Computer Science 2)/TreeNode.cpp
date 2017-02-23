#include <iostream>
class TreeNode{
public:
	int value;
	TreeNode *left;
	TreeNode *right;
	TreeNode *next;

	TreeNode(int input){
		value = input;
		left = NULL;
		right = NULL;
	}
};