// normal_distribution
#include <iostream>
#include <random>

int main()
{
  std::default_random_engine generator;
  std::uniform_int_distribution<int> distribution(1,6);
  for (int i = 0; i < 5; ++i) {
    auto dice = std::bind ( distribution, generator );
  
  int wisdom = dice()+dice()+dice();
  std::cout << wisdom;
  }
}