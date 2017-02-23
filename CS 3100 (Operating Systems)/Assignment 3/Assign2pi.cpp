#include "Assign2pi.hpp"

long double findPi(int num) { //computes pi to the specified precision using the Nilakantha series
	int denominator = 2;
	long double result = 3;
	for (int i = 0; i < 10000; ++i) {
		result += 4.0 / (denominator*(denominator + 1)*(denominator + 2));
		denominator += 2;
		result -= 4.0 / (denominator*(denominator + 1)*(denominator + 2));
		denominator += 2;
	}
	result = roundf(result * powf(10, num)) / powf(10, num);
	return result;
}

std::string errorPi() { //if incorrect value is entered for pi calculation
	return "Please enter a number between 1 and 10.";
}

std::string piInput(int num) { //handles user input for pi calculation
	if (num > 0 && num < 11) {
		return std::to_string(findPi(num));
	}
	return errorPi(); //if user enters incorrect value
}