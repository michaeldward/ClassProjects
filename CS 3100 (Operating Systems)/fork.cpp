#include <iostream>
#include <string>
#include <unist.h>
#include <sys/wait.h>

int main()
{
	std::string whoAmI = "Unknown";
	int testValue = 10;
	std::cout << "This is a form demo!" << std::endl;
	pid_t pid; //actually an int, but pid_t is used for some systems
	pid = fork();

	if (pid) {
		whoAmI = "Parent";
		wait(NULL);
		std::cout << "Called from the parent" << std::endl;
		testValue = 12;
	}
	else {
		whoAmI = "Child";
		std::cout << "Called from the child" << std::endl;
		testValue = 14;
	}

	std::cout << "From the " << whoAmI << " the value is: " << testValue << std::endl;
	std::cout << "Reported from pid" << pid << std::endl;

	return 0;
}