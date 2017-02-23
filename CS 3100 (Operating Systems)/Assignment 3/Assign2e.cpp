#include "Assign2e.hpp"

int factorial(int num) { //calculates the factorial of the number specified
	int result = num;
	for (int i = num - 1; i > 0; --i) {
		result *= i;
	}
	return result;
}

double findE(int num) { //finds e to the specified precision using the Taylor series
	double result = 1;
	for (int i = 1; i < num; ++i) {
		result += 1.0 / factorial(i);
	}
	return result;
}

std::string errorE() { //if incorrect value is entered for e calculation
	return "Please enter a number between 1 and 30.";
}

std::string eInput(int num) { //handles user input for e calculation
	if (num > 0 && num < 31) {
		return std::to_string(findE(num));
	}
	return errorE(); //if user enters incorrect value
}