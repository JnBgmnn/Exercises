'''
Created on 08.01.2018

@author: Jan
'''

def getUserInput():
    string = input("Enter a string")
    return string

def reverse(string):
    split = string.split(' ')
    reverse = []
    for i in range(1, len(split) + 1):
        reverse.append(split[-i])
    print(reverse)
    return reverse
    
def buildString(reverse):
    string = ""
    for i in range(len(reverse)):
        string += "%s" % reverse[i]
    print(string)
    
buildString(reverse(getUserInput()))