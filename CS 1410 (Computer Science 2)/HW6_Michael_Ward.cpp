#include <iostream>
#include <cstdlib>
#include <ctime>
#include <iomanip>
#include <Windows.h>

clock_t clock(void);

void bubbleSort(int[], int);
void selectionSort(int[], int);
void instertionSort(int[], int);
void quickSort(int[], int, int);
int partition1(int[], int, int);
void mergeSort(int[], int[], int, int);
void doMerge(int[], int[], int, int, int);
int partition2(int[], int, int);
void swap(int, int);
void generateArray(int[], int);
void generateAllArrays(int);

int randArray1[1000];
int randArray2[1000];
int randArray3[1000];
int randArray4[1000];
int randArray5[1000];
int arraySize = 0;
int temp[10000];
void printArray(int[], int);
void timeArrays(int);

int main()
{
	timeArrays(10);
	
	/*
	generateAllArrays(10);
	Test array sorting is correct:
	printArray(randArray1, arraySize);
	instertionSort(randArray1, arraySize);
	printArray(randArray1, arraySize);
	printArray(randArray2, arraySize);
	bubbleSort(randArray2, arraySize);
	printArray(randArray2, arraySize);
	printArray(randArray3, arraySize);
	selectionSort(randArray3, arraySize);
	printArray(randArray3, arraySize);
	printArray(randArray4, arraySize);
	quickSort(randArray4, 0, arraySize);
	printArray(randArray4, arraySize);
	printArray(randArray5, arraySize);
	mergeSort(randArray5, temp, 0, arraySize);
	printArray(randArray5, arraySize);
	*/
}

void timeArrays(int number){
	double iterations = 10;
	double insertionMaster = 0, bubbleMaster = 0, selectionMaster = 0, quickMaster = 0, mergeMaster = 0;
	for (int n = 0; n < iterations; ++n){
		generateAllArrays(number);
		clock_t before, after, timerstart;
		double insertionTimer = 0, bubbleTimer = 0, selectionTimer = 0, quickTimer = 0, mergeTimer = 0;
		before = std::clock();
		std::cout << before;
		instertionSort(randArray1, arraySize);
		after = std::clock();
		insertionTimer = (after - before);
		std::cout << insertionTimer << std::endl;
		timerstart = std::clock();
		bubbleSort(randArray2, arraySize);
		bubbleTimer = std::clock() - timerstart;
		timerstart = std::clock();
		selectionSort(randArray3, arraySize);
		selectionTimer = std::clock() - timerstart;
		timerstart = std::clock();
		quickSort(randArray4, 0, arraySize);
		quickTimer = std::clock() - timerstart;
		timerstart = std::clock();
		mergeSort(randArray5, temp, 0, arraySize);
		mergeTimer = std::clock() - timerstart;
		insertionMaster += insertionTimer;
		bubbleMaster += bubbleTimer;
		selectionMaster += selectionTimer;
		quickMaster += quickTimer;
		mergeMaster += mergeTimer;
	}
	insertionMaster /= iterations;
	bubbleMaster /= iterations;
	selectionMaster /= iterations;
	quickMaster /= iterations;
	mergeMaster /= iterations;
	std::cout << std::fixed;
	std::cout << number << " variables: " << std::endl;
	std::cout << "Insertion Sort:" << insertionMaster << std::endl;
	std::cout << "Bubble Sort: " << std::setprecision(100) << bubbleMaster << std::endl;
	std::cout << "Selection Sort: " << std::setprecision(100) << selectionMaster << std::endl;
	std::cout << "Quick Sort: " << std::setprecision(100) << quickMaster << std::endl;
	std::cout << "Merge Sort: " << std::setprecision(100) << mergeMaster << std::endl;
}

void printArray(int array[], int size){
	for (int n = 0; n < size; ++n){
		std::cout << array[n] << std::endl;
	}
	std::cout <<std::endl;
}

void generateAllArrays(int size){
	for (int n = 0; n < size; ++n){
		randArray1[n] = rand() % size;
		randArray2[n] = randArray1[n];
		randArray3[n] = randArray1[n];
		randArray4[n] = randArray1[n];
		randArray5[n] = randArray1[n];
	}
	arraySize = size;
}

void generateArray(int array[], int size){
	for (int n = 0; n < size; ++n){
		array[n] = rand() % size;
	}
}

void bubbleSort(int array[], int size){
	int temp; bool swapOccurred;
	do {
		swapOccurred = false;
		for (int count = 0; count < (size - 1); count++) {
			if (array[count] > array[count + 1]) {
				temp = array[count];
				array[count] = array[count + 1];
				array[count + 1] = temp; swapOccurred = true;
			}
		}
	} while (swapOccurred);
}

void selectionSort(int array[], int size){
	int temp; int position = -1; for (int i = 0; i < size; i++) {
		temp = array[i]; position = i;
		for (int count = i + 1; count < size; count++) {
			if (temp > array[count]) {
				temp = array[count]; position = count;
			}
		}
		if (position != i)
		{
			temp = array[i];
			array[i] = array[position];
			array[position] = temp;
		}
	}
}

void instertionSort(int array[], int size){
	int temp, m;
	for (int n = 1; n < size; ++n){
		temp = array[n];
		m = n - 1;
		while (m >= 0 && array[m] > temp){
			array[m + 1] = array[m];
			m = m - 1;
		}
		array[m + 1] = temp;
	}
}


void mergeSort(int numbers[], int temp[],  int left, int right){
	
	int mid;
	if (right > left){
		mid = (right + left) / 2;
		mergeSort(numbers, temp, left, mid);
		mergeSort(numbers, temp, (mid + 1), right);
		doMerge(numbers, temp, left, (mid + 1), right);
	}
}

void doMerge(int numbers[], int temp[], int left, int mid, int right){
	//int temp[25];
	int i, left_end, num_elements, tmp_pos;
	left_end = (mid - 1);
	tmp_pos = left;
	num_elements = (right - left + 1);
	while ((left <= left_end) && (mid <= right))
	{
		if (numbers[left] <= numbers[mid])
			temp[tmp_pos++] = numbers[left++];
		else
			temp[tmp_pos++] = numbers[mid++];
	}
	while (left <= left_end)
		temp[tmp_pos++] = numbers[left++];
	while (mid <= right)
		temp[tmp_pos++] = numbers[mid++];
	for (i = 0; i < num_elements; i++)
		numbers[right--] = temp[right];

}

void quickSort(int arr[], int left, int right)
{
	int i = left, j = right;
	int tmp;
	int pivot = arr[(left + right) / 2];

	/* partition */
	while (i <= j)
	{
		while (arr[i] < pivot)
			i++;
		while (arr[j] > pivot)
			j--;
		if (i <= j)
		{
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;
		}
	}

	/* recursion */
	if (left < j)
		quickSort(arr, left, j);
	if (i < right)
		quickSort(arr, i, right);
}

int partition2(int arr[], int start, int end)
{
	int index = start;
	int pivotValue = arr[start];

	for (int scan = start + 1; scan <= end; scan++)
	{
		if (arr[scan] < pivotValue)
		{
			swap(arr[index + 1], arr[scan]);
			swap(arr[index], arr[index + 1]);
			index++;
		}
	}

	return index;
}



int partition1(int arr[], int start, int end){
	int index = start;
	int pivotValue = arr[start];

	for (int scan = start + 1; scan <= end; scan++)
	{
		if (arr[scan] < pivotValue)
		{
			index++;
			swap(arr[index], arr[scan]);
		}
	}
	swap(arr[start], arr[index]);

	return index;
}

void swap(int a1, int a2){
	int temp = a1;
	a1 = a2;
	a2 = temp;
}