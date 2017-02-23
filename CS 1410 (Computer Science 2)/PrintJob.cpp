#include <string>
class PrintJob{
public:
	int number;
	std::string filename;
	PrintJob* next;
	PrintJob(){
		next = NULL;
	}
	PrintJob(std::string newName, int newInt){
		filename = newName;
		number = newInt;
		next = NULL;
	}
};