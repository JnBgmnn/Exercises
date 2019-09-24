'''

Created on 23.12.2016

@author: Jan
'''
def first():
    number = input("Please enter a number")
    if int(number) % 2 == 0:
        if int(number) % 4 == 0:
            print("%s is a multiple of 4" % number)
        else:
            print("%s is an even number" % number)
    else:
        print("%s is an odd number" % number)
        
def second():
    first = input("Please enter the first number")
    second = input("Please enter the second number")
    if int(first) % int(second) == 0:
        print("%s divides evenly into %s" % (first, second))
    else:
        print("%s does not divide evenly into %s" % (first, second))
        
second()