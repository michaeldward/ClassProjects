#Michael Ward
#A01755332
#CS 3430 Midterm 1 Problem 1

def return_sum(N):
    sum = y = z = 0
    if N > 0:
        y = N
        z = 2*N + 1
    elif N < 0:
        y = 2*N
        z = N + 1
    for x in range(y, z):
        sum += x
    return sum

def get_input():
    x = input('Enter number: ')
    print 'Sum :', return_sum(x)
    

get_input()
