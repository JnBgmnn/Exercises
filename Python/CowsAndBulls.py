'''
Created on 11.01.2018

@author: Jan
'''
import random

rng = list(str(random.randint(0, 10000)))
print(rng)
array = [None] * len(rng)
for i in range(len(rng)):
    array[i + 4 - len(rng)] = rng[i]
print(array)

# array = ['0', '0', '0', '0']
#rng = list(str(random.randint(0, 10000)))
#for i in range(len(rng)):
#    array[i + 4 - len(rng)] = rng[i]
#print(array)
#while True:
#    help = [None, None, None, None]
#    guess = list(input("Guess the number"))
#    for i in range(len(guess)):
#        help[i + 4 - len(guess)] = guess[i]
#    print(help)
#    cows = 0
#    bulls = 0
#    for i in range(len(array)):
#       if array[i] == help[i]:
#           array[i] = None
#            cows += 1
#   print(help)
#   if cows == len(array):
 #       print("Correct")
#        exit(0)
#    for i in range(len(array)):
#        if help[i] in array:
#            bulls += 1
#    print("Cows: %d \nBulls: %d" % (cows, bulls))
#    cows = 0
#   bulls = 0 