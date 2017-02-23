//Assignment 3; Michael Ward
#include "Assign2e.hpp"
#include "Assign2Fib.hpp"
#include "Assign2pi.hpp"


std::string showHelp() { //if incorrect command is entered
	return "--- Assign 1 Help ---\n\n-fib [n] Compute the fibonacci of [n]\n\n-e [n] Compute the value of 'e' using [n] iterations\n\n-pi [n] Compute Pi to [n] digits";
}

std::string userInput(char prompt[], int number) { //handles user input and determines calculation
	if (prompt[0] == '-') {
		if (prompt[1] == 'f') { //checks if prompt is fib
			if (prompt[2] == 'i') {
				if (prompt[3] == 'b') {
					return fibInput(number);
				}
			}
		}
		else if (prompt[1] == 'e') { //checks if prompt is e
			return eInput(number);
		}
		else if (prompt[1] == 'p') { //checks if prompt is pi
			if (prompt[2] == 'i') {
				return piInput(number);
			}
		}
	}
	return showHelp(); //if input is not correct
}

int main(int argc, char* argv[]) {
	if (argc >= 3) {
		if(isdigit(argv[2][0])) {
			int number = std::stoi(argv[2]);
			std::cout << userInput(argv[1], number) << std::endl;
			}
		else {
			std::cout << showHelp() << std::endl;
			}
	}
	else {
		std::cout << showHelp() << std::endl;
	}
}