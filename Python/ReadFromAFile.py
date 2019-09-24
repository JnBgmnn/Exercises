'''
Created on 12.01.2018

@author: Jan
'''

def countNames(lines):
    names = {}
    for line in lines:
        if line in names:
            names[line] += 1
        else:
            names[line] = 1
    print(names)
    
def countCategories(lines):
    categories = {}
    for line in lines:
        if line in categories:
            categories[line] += 1
        else:
            categories[line] = 1
    print(categories)

fileOne = open('', 'r')
textOne = fileOne.read()
linesOne = textOne.split("\n")
countNames(linesOne)

fileTwo = open('', 'r')
textTwo = fileTwo.read()
linesTwo = textTwo.split("\n")
splitted = []
for line in linesTwo:
    splittedLines = line.split("/")
    if(len(splittedLines) > 1):
        splitted.append(splittedLines[2])
countCategories(splitted)