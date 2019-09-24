'''
Created on 08.01.2018

@author: Jan
'''

def fibonacci(num):
    if num < 0:
        print("Please enter a non-negative natural number")
    fibs = [0, 1]
    for i in range(2, num):
        fibs.append(fibs[i - 1] + fibs[i - 2])
    print(fibs) 

num = input("How many Fibonacci numbers should be generated?")
fibonacci(int(num))
