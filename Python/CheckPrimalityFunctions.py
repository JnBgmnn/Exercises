'''
Created on 08.01.2018

@author: Jan
'''

number = input("Please enter a number")
if int(number) < 1:
    print("%s is not prim" % number)
    exit(0)
for i in range(2, int(number)):
    if int(number) % i == 0:
        print("%s is not prim" % number)
        exit(0)
print("%s is  prim" % number)
        