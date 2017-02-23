#Michael Ward
#CS 3430 Midterm 1 Problem 2

def print_date(N):
    N = int(N)
    error = False
    month = N / 1000000
    monthArray = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']
    if month in range(1, 13):
        month = monthArray[month - 1]
    else:
        error = True
    day = (N / 10000) % 100
    if day not in range(1, 32):
        error = True
    year = N % 10000
    if error is not True:
        print "%s %d, %d" %(month, day, year)
    else:
        print 'Invalid date'

def user_input():
    x = raw_input('Enter date: ')
    print_date(x)

user_input()
