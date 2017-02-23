#include <iostream>
#include <iomanip>
#include <ctime>

long long fibonacci2(long long index) {
    if(index == 0) {
        return 0;
    }
    else if (index == 1){
        return 1;
    }
    else {
        return fibonacci2(index - 1) + fibonacci2(index - 2);
    }
}

int main() {
    while (true){
        clock_t start = clock();
    	std::cout << fibonacci2(48) << std::endl;
    	std::cout << " " << std::setprecision(10) << float((clock() - start) / double(CLOCKS_PER_SEC)) << std::endl;
    }
}