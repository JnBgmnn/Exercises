'''
Created on 08.01.2018

@author: Jan
'''

import random

def generatePasswordLength():
    length = random.randint(8, 15)
    return length

def generatePassword(length):
    pw = []  
    for i in range(length):
        pw.append(chr(random.randint(33, 126)))
    string = "".join(str(x) for x in pw)
    return string

print(generatePassword(generatePasswordLength()))