#include <iostream>
#include <iomanip>
#include <ctime>

long long fibonacci(int index) {
    if (index < 0) { //check to see if index is invalid. If so, return -1
        return -1;
    }
    else if (index == 0) { //check to see if index is 1. If so, return 1
        return 0;
    }
    else { //if index is greater than one, returns fibonacci value stored in b
        long long a = 0, b = 1;
        for (int i = 1; i < index; ++i) {
            long long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}

int main() {
    while (true){
        int newInt;
        std::cin >> newInt;
        clock_t start = clock();
        std::cout << " " << fibonacci(newInt) << std::endl;
        std::cout << " " << std::setprecision(10) << float((clock() - start) / double(CLOCKS_PER_SEC)) << std::endl;
    }
}