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
 1. When f(x, 4) is called, the computer passes x to arr, and 4 to k. Since x is an array, it is passed-by-value as its memory address. Thus, arr = 1000 and k = 4.
2. In line 2, the computer allocates a memory block in the current stack frame for the pointer p and assigns the value of arr to p. Thus, p = 1000.
3. The computer starts the for loop in line 3 with i = 0.
4. Since i = 0 and k = 4, i < k is true, the body of the for loop is executed.
5. In line 4, p is dereferenced (via the expression *p). Since p = 1000, it points to arr[0], which is also x[0]. Therefore, x[0] = 1 is written to the out stream, 
followed by a dash (" - ").
6. In line 5, p is incremented by an offset of 2. Since p is an int pointer, its actual value is incremented by 2 * sizeof(int) = 8. Thus, p has a new value of 1000+8 
= 1008 and points to arr[2], which is also x[2].
7. The computer comes back to the for loop in line 3 and increases i by 1. Thus, i = 1.
8. Since i = 1 and k = 4, i < k is true, the execution of the body of the for loop is continued.
9. In line 4, p is dereferenced (via the expression *p). Since p = 1008, it points to arr[2], which is also x[2]. Therefore, x[2] = 3 is written to the out stream, 
followed by a dash (" - ").
10. In line 5, p is incremented by 2 * sizeof(int) = 8; thus, p = 1016 and points to arr[4]
11. The program moves back to the condition at the beginning of the for loop in line 3. i = 2, which is less than k=4, so i < k is true, and the code inside the for loop is executed
12. In line 4, p is dereferenced, displaying the value of arr[4] (also x[4]) to the console, which is 6. This is followed by a dash.
13. In line 5, p is incremented by 2 * sizeof(int), resulting in p = 1024.
14. The program moves back to the conditional statement at the beginning of the for loop. i = 3, which is less than 4, so the program proceeds into the for loop.
15. the dereferenced p is outputted to the console, which is x[6] = 2, followed by a dash.
16. In line 5, p is incremented by 2 * sizeof(int), resulting in p=1032
17. The program returns to the conditon at the beginning of the for loop, which is now false since i = 4, so the code in the loop is not executed.
*/

/*
1b: After the function is finished,  p = 1032 and it points to what is stored 4 bytes after the last member of the array.
We do not know what, if anything, is stored there. Therefore, the result will be a completely random number. Example: 1606416720
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