'''
Created on 08.01.2018

@author: Jan
'''

a = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]
b = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]

list = [x for x in a for y in b if x == y]

print(set(list))