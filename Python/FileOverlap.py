'''
Created on 12.01.2018

@author: Jan
'''

def readFile(fileOne, fileTwo):
    happy = fileTwo.readlines()
    result = []
    for line in fileOne:
        if line in happy:
            result.append(line.rstrip('\n'))
    return result
    
fileOne = open("")
fileTwo = open("")
print(readFile(fileOne, fileTwo))