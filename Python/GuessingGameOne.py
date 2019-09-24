'''
Created on 08.01.2018

@author: Jan
'''
import random

def game():
    counter = 0
    while True:
        rng = random.randrange(1, 10, 1)
        while True:
            guess = input("Guess the number!")
            if guess == '':
                print("Please enter a number")
                continue
            counter += 1
            if guess == "exit":
                return
            if int(guess) == rng:
                print("""Congratulations! You guessed the right number\nNumber of \
guesses: %d""" % counter)
                break
            if int(guess) < rng:
                print("higher")
            if int(guess) > rng:
                print("smaller")
                
game()
