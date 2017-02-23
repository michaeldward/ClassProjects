#include <iostream>
#include <string>

class MixinBase {
private:
	std::string name;
public:
	virtual void setName(std::string n) { name = n; }
	virtual std::string whoAmI() { return name; }
};

template<class T>
class Employee : public T {
public:
	Employee(std::string name) { T::setName(name); }
	std::string whoAmI() { return T::whoAmI(); }
};

template<class T>
class Manager : public T {
public:
	Manager(std::string name) : T(name){};
	std::string whoAmI() { return T::whoAmI(); }
};

int main()
{
	Employee<MixinBase> emp("Bob");
	Manager<Employee<MixinBase>> mgr("Mary");
	std::cout << emp.whoAmI() << std::endl;
	std::cout << mgr.whoAmI() << std::endl;
}
