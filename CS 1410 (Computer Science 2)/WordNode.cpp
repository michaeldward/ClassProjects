#include <string>

class WordNode{
public:
	std::string word;
	int frequency;
	WordNode* left;
	WordNode* right;
	//constructors
	WordNode();
	WordNode(std::string, int, WordNode*, WordNode*);
	std::string getWord(){ return word; }
};
WordNode::WordNode(std::string newWord, int newFreq, WordNode *left = NULL, WordNode *right = NULL){
	word = newWord;
	frequency = newFreq;
}
WordNode::WordNode(){
	left = NULL;
	right = NULL;
	frequency = 0;
}
