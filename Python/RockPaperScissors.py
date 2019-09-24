'''
Created on 07.01.2018

@author: Jan
'''



def game():
    points1 = 0
    points2 = 0
    while True:
        player1 = input("Choose your move")
        player2 = input("Choose your move")
        
        if player1 == player2:
            print("Tie")
        
        if player1.lower() == "rock":
            if player2.lower() == "scissors":
                points1 += 1
                print("Player 1 won\nScore:\n Player 1: %d\n Player 2: %d" % (points1, points2))
            if player2.lower() == "paper":
                points2 += 1
                print("Player 2 won\nScore:\n Player 1: %d\n Player 2: %d" % (points1, points2))
        if player1.lower() == "scissors":
            if player2.lower() == "rock":
                points2 += 1
                print("Player 2 won\nScore:\n Player 1: %d\n Player 2: %d" % (points1, points2))
            if player2.lower() == "paper":
                points1 += 1
                print("Player 1 won\nScore:\n Player 1: %d\n Player 2: %d" % (points1, points2))
        if player1.lower() == "paper":
            if player2.lower() == "scissors":
                points2 += 1
                print("Player 2 won\nScore:\n Player 1: %d\n Player 2: %d" % (points1, points2))
            if player2.lower() == "rock":
                points1 += 1
                print("Player 1 won\nScore:\n Player 1: %d\n Player 2: %d" % (points1, points2))
        if points1 == 3:
            print("Congratulations Player 1!\nYou won")
            break
        if points2 == 3:
            print("Congratulations Player 2!\nYou won")
            break
        
game()