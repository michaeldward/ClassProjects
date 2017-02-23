#include <iostream>
const int SIZE = 1000;
class Stack {
public:
	int size();
	bool isEmpty();
	void push(char);
	char pop();
	char data[SIZE];
	int count = 0;
};

int Stack::size() {
	return count;
}

bool Stack::isEmpty() {
	return count == 0;
}

void Stack::push(char newItem) {
	if (count < SIZE) {
		data[count] = newItem;
		++count;
	}
}

char Stack::pop() {
	if (!isEmpty()) {
		return data[--count];
	}
}

bool palindromeTester(std::string word){
	Stack palindromeTester;
	int size = word.size();
	for (int i = 0; i < size; ++i){
		palindromeTester.push(word[i]);
	}
	char* secondWord = new char[size];
	for (int i = 0; i < size; ++i) {
		secondWord[i] = palindromeTester.pop();
		if (secondWord[i] != word[i]) {
			return false;
		}
	}
	return true;
}

int main() {
	if (palindromeTester("racecar")){
		std::cout << "True\n";
	}
	else {
		std::cout << "False\n";
	}
	
}

/* EXPLANATION:
My algorithm uses a stack. It pushes the letters of the word one by one into the stack, and then pops them out into a character array.
If the new character array is then the reverse of the original word, so if it equals the original word, then the original word is a palindrome.
The algorithm tests each letter as soon as it is popped and if it is not equal to equivalent letter in the original word, it will return false.
The complexity of this algorithm is O(n), because a push and pop are required for each letter of the word.
*/