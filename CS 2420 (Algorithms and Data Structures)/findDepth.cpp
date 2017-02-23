/*
Michael Ward
A01755332
CS2420 with Dr. Kyumin Lee
Assignment 3 Coding Part 1
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

void findDepthRecursive(TreeNode* node, int num, int depth, int &foundDepth) {
	if (checkNode(node, num)) {
		foundDepth = depth;
	}
	if (node->left != NULL) {
		findDepthRecursive(node->left, num, depth + 1, foundDepth);
	}

	if (node->right != NULL) {
		findDepthRecursive(node->right, num, depth + 1, foundDepth);
	}
}

int findDepth(TreeNode* root, int value){
	int foundDepth = -1;
	findDepthRecursive(root, value, 0, foundDepth);
	return foundDepth;
}







int main(){
	std::string filename = "D:/tree.txt"; //change to your location of the file
	TreeNode* root = new TreeNode(0);
	addTree(filename, root);
	//displayTree(root);
	int search, answer;
	while (true){
		std::cout << "Please enter a node's value: ";
		std::cin >> search;
		answer = findDepth(root, search);
		if (answer == -1){
			std::cout << "Node with value " << search << " was not found in the tree.\n";
		}
		else{
			std::cout << "Node with value " << search << " was found at depth " << answer << ".\n";
		}
	}
}