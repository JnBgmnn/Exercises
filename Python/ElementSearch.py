'''
Created on 11.01.2018

@author: Jan
'''

import random

def CheckIfElementIsInList(orderedList, number):  
    middle = int(len(orderedList) / 2)
    if(len(orderedList) == 0):
        return False
    if orderedList[middle] == number:
        return True
    elif orderedList[middle] < number:
        return CheckIfElementIsInList(orderedList[middle + 1:], number)
    elif orderedList[middle] > number:
        return CheckIfElementIsInList(orderedList[:middle], number)

randomList = set([random.randrange(30) for i in range(20)])
orderedList = sorted(randomList)
number = 20
print(orderedList)
print(number)
print(CheckIfElementIsInList(orderedList, number))