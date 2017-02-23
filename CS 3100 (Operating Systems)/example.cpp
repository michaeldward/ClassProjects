#include <iostream>
#include <cstdlib>
#include <cmath>
#include <dlfcn.h>

int main(int argc, char* argv[]) {

	void* handle = dlopen("./DemoLib.so", RTLD_LAZY);
	if (!handle) {
		std::cout << "Couldn't open the shared library, error: " << dlerror() << std::endl;
		exit(1);
	}

	double (*function)(int) = (double(*)(int))dlsym(handle, "demo");
	if(dlerror() != NULL) {
		std::cout << "Couldn't find 'demo', error: " << dlerror() << std::endl;
		exit(1);
	}

	double result = function(2);
	std::cout << "Returned value: " << result << std::endl;

	dlclose(handle);
	return 0;
}