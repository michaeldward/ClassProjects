Assign2: Assign2.o Assign2e.o Assign2Fib.o Assign2pi.o
	g++ -std=c++11 -o Assign2 Assign2.o Assign2e.o Assign2Fib.o Assign2pi.o

Assign2.o: Assign2.cpp
	g++ -std=c++11 -c Assign2.cpp

Assign2e.o: Assign2e.cpp Assign2e.hpp
	g++ -std=c++11 -c Assign2e.cpp

Assign2Fib.o: Assign2Fib.cpp Assign2Fib.hpp
	g++ -std=c++11 -c Assign2Fib.cpp

Assign2pi.o: Assign2pi.cpp Assign2pi.hpp
	g++ -std=c++11 -c Assign2pi.cpp

clean:
	rm *.o
	rm Assign2