#include <iostream>

bool findNumber(int numbers[], int find, int N) {
	for (int i = 0; i < N - 1; ++i) {
		if (numbers[i] == find) {
			return true;
		}
	}
	return false;
}
int findMissing(int numbers[], int N) {
	for (int i = 1; i < N; ++i) {
		if (findNumber(numbers, i, N) == false) {
			return i;
		}
	}
}



int main() {
	int numbers[19] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20 };
	std::cout << findMissing(numbers, 20);
}


/* EXPLANATION:
My algorithm traverses the entire array for each number from 1 to N. For each number, it traverses the entire array and searches for the selected number.
If the number is not found, it will return that number as that is the missing number. If the number is found, it will move on to the next number.
My algorithm assumes that one number will be missing and is not built to handle an array in which no or more than one number is missing.
The complexity of my algorithm is O(n^2) because it has to traverse the entire array for each number from 1 to N.
*/