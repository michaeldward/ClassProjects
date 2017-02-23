#include <string>
#include <iostream>

bool palindrome(std::string word)
{
	int start = 0;
	int end = word.length() - 1;
	while (start < end)
	{
		if (word[start] == word[end])
		{
			++start;
			--end;
		}
		else
		{
			return false;
		}
	}
	return true;
}


int main()
{
	std::cout << palindrome("racecar");
}