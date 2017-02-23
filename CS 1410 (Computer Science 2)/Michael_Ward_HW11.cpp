#include "WordNode.cpp"

void insert(WordNode* &, std::string, int);

int main(){

}

//head node for tree, word, and frequency of new word
void insert(WordNode* &node, std::string word, int frequency){
	if (node == NULL){
		node = new WordNode(word, frequency, new WordNode, new WordNode);
	}
	else if (word > node->word){
		insert(node->right, word, frequency);
	}
	else if (word < node->word){
		insert(node->right, word, frequency);
	}
	else if (word == node->word){
		++node->frequency;
	}
}