'''
Created on 08.01.2018

@author: Jan
'''
import random

def removeDuplicates(a):
    b = []
    for i in range(len(a)):
        if a[i] not in b:
            b.append(a[i])
    return b

a = [random.randrange(20) for i in range(10)]
print(a)
print(removeDuplicates(a))

