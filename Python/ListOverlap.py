'''
Created on 07.01.2018

@author: Jan
'''
import random

a = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]
b = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]

def first():
    list = []
    for index in range(len(a)):
        if a[index] in b:
            list.append(a[index])
    print(set(list))

def second():
    firstList = random.sample(range(30), 10)
    secondList = random.sample(range(50), 15)
    resultList = []
    for index in range(len(firstList)):
        if firstList[index] in secondList:
            resultList.append(firstList[index])
    print("The first list is " + str(firstList))
    print("The second list is " + str(secondList))
    print(resultList)
    
first()
second()