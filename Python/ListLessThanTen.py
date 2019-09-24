a = [1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]

def first():
    "Prints every entry that is less than five"
    for index in range(len(a)):
        if(a[index] < 5):
            print(a[index])
            
def second():
    "Creates a new list where every entry is less than five \
    and prints the list"
    list = []
    for index in range(len(a)):
        if(a[index] < 5):
            list.append(a[index])
    print(list)
    
def third():
    "Asks the user for a number and returns a list that contains \
    only elements from the original list \"a\" that are smaller \
    than the number given by the user"    
    number = input("Please enter a number")
    list = []
    for index in range(len(a)):
        if a[index] < int(number):
            list.append(a[index])
    print(list)

first()
second()
third()