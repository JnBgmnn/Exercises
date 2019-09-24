'''
Created on 07.01.2018

@author: Jan
'''

def first():
    string = input("Please enter a string")
    if string == string[::-1]:
        print("%s is a palindrome" % string)
    else:
        print("%s is not a palindrome" % string)
        
first()