'''
Created on 07.01.2018

@author: Jan
'''

def first():
    number = input("Please enter a number")
    for index in range(1, int(number) + 1):
        if int(number) % index == 0:
            print(index)

first()