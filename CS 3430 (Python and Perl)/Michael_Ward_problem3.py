#Michael Ward
#CS 3430 Midterm 1 Problem 3


import string, random

def make_passwords():
    for x in range(0, 5):
        password = ''
        password += random.choice(string.ascii_uppercase)
        for y in range(0, 6):
            password += random.choice(string.ascii_lowercase)
        password += random.choice(string.digits)
        returnList = []
        returnList.append('Password ' + `x + 1`)
        returnList.append(password)
        print returnList

make_passwords()
