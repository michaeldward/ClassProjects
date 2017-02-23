#include <iostream>
#include <iomanip>
#include <cmath>

void f(int*, int);

//int main(){
//
//}

//Task 1:
void f(int *arr, int k) {
	int *p = arr;
	for (int i = 0; i < k; i++) {
		std::cout << *p << " - ";
		p += 2;
	}
}

//Task 1a:
//sizeof(int) = 4
//int x[] = { 1, 4, 3, 7, 6, 5, 2 };
//&x = 1000
/*
Execution:

*/


int main()
{
	int number = 1;
	int* pNumber = &number;
	std::cout << *pNumber << std::endl;
	std::cout << pNumber << std::endl;
	int number2 = 2;
	int &rNumber2 = number2;
	std::cout << rNumber2 << std::endl;
	std::cout << &rNumber2 << std::endl;
}