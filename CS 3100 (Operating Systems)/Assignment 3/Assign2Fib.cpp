#include "Assign2Fib.hpp"

int fibonacci(int num){//calculates the specified fibonacci number
	if (num == 0) { //if number entered is 0
		return 0;
	}
	long num1 = 0, num2 = 1;
	for (int i = 0; i < num - 1; ++i) {
		int temp = num2;
		num2 += num1;
		num1 = temp;
	}
	return num2;
}

std::string errorFib() { //if incorrect value is entered for fibonacci calculation
	return "Please enter a number between 0 and 14.";
}

std::string fibInput(int num) { //handles user input for fibonacci calculation
	if (num < 15 && num >= 0) {
		return std::to_string(fibonacci(num));
	}
	return errorFib(); //if user enters incorrect value
}