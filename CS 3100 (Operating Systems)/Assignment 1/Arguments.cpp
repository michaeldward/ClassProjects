#include <iostream>
using namespace std;


int main(int argc, char *argv[])
{

	cout << "There are " << argc << " parameters." << endl;

	for (int Param=0; Param<argc; Param++)
	{
		cout << "Param " << (Param+1) << ": " << argv[Param] << endl;
	}

return 0;
}

