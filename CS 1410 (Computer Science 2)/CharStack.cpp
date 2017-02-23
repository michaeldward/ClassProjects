class CharStack{
private:
	char *stackArray;
	int capacity;
	int top;
public:
	~CharStack(){ delete[] stackArray; }

	CharStack(int newCapacity){
		this->capacity = newCapacity;
		stackArray = new char[capacity];
		top = 0;
	}
	void CharStack::push(char newValue){
		if (top == capacity)throw CharStack::Overflow();
		else{
			stackArray[top] = newValue;
			++top;
		}
	}

	bool CharStack::isEmpty() const{
		if (!top)
			return true;
		else
			return false;
	}

	void CharStack::pop(char& newValue){
		if (isEmpty()) throw CharStack::Underflow();
		else{
			top--;
			newValue = stackArray[top];
		}
	}

	//Stack Exceptions
	class Overflow{};
	class Underflow{};
};



