/*
Michael Ward
A01755332
CS2420 with Dr. Kyumin Lee
Assignment 3 Coding part 2
*/

#include <iostream>
#include <fstream>



class TreeNode {
public:
	int value;
	TreeNode* right = NULL;
	TreeNode* left = NULL;
	TreeNode(int);
};

TreeNode::TreeNode(int newValue) {
	value = newValue;
}
bool checkNode(TreeNode* node, int num) {
	if (node->value == num) return true;
	else return false;
}
void findNodeRecursive(TreeNode* node, int num, TreeNode* &found) {
	if (checkNode(node, num)) {
		found = node;
	}
	if (node->left != NULL) {
		findNodeRecursive(node->left, num, found);
	}
	if (node->right != NULL) {
		findNodeRecursive(node->right, num, found);
	}
}

TreeNode* findNode(TreeNode* node, int num) {
	TreeNode* found = NULL;
	findNodeRecursive(node, num, found);
	return found;
}

void addNode(TreeNode* root, int value, int parent, int command) {
	TreeNode* found;
	switch (command)
	{
	case 2:
		root->value = value;
		break;
	case 0:
		found = findNode(root, parent);
		if (found != NULL) {
			if (found->left == NULL) {
				found->left = new TreeNode(value);
			}
		}
		break;
	case 1:
		found = findNode(root, parent);
		if (found != NULL) {
			if (found->right == NULL) {
				found->right = new TreeNode(value);
			}
		}
		break;
	}
}

void addTree(std::string filename, TreeNode* root) {
	std::ifstream fin;
	fin.open(filename);
	while (!fin.eof()){
		int num1, num2;
		char comma;
		char command[7];
		fin >> num1;
		fin >> comma;
		fin >> num2;
		fin >> comma;
		fin >> command;
		int commandNum; //0 for left, 1 for right, 2 for root
		if (command[0] == 'r') {
			if (command[1] == 'i') {
				commandNum = 1;
			}
			else {
				commandNum = 2;
			}
		}
		else {
			commandNum = 0;
		}
		addNode(root, num1, num2, commandNum);
	}
}

void displayTree(TreeNode* node) {
	std::cout << node->value << std::endl;
	if (node->left != NULL) {
		displayTree(node->left);
	}
	if (node->right != NULL) {
		displayTree(node->right);
	}
}

void removeLeaves(TreeNode* node) {
	if (node->left != NULL) {
		if (node->left->left == NULL && node->left->right == NULL) {
			node->left = NULL;
		}
		else {
			removeLeaves(node->left);
		}
	}
	if (node->right != NULL) {
		if (node->right->left == NULL && node->right->right == NULL) {
			node->right = NULL;
		}
		else {
			removeLeaves(node->right);
		}
	}
}


int main(){
	std::string filename = "D:/tree.txt"; //change to your location of the file
	TreeNode* root = new TreeNode(0);
	addTree(filename, root);
	removeLeaves(root); //remove leaf nodes
	std::cout << "Tree after removing leaf nodes: \n";
	std::cout << "(pre-order traversal of tree)\n";
	displayTree(root);
}