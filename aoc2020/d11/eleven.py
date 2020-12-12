from itertools import product
import copy
#Game of life
FLOOR = '.'
EMPTY_SEAT = 'L'
OCCUPIED_SEAT = '#'
#All decisions are based on the number of occupied seats adjacent to a given seat 
#(one of the eight positions immediately up, down, left, right, or diagonal from the seat)

#If a seat is empty (L) and there are no occupied seats adjacent to it, the seat becomes occupied.
#If a seat is occupied (#) and four or more seats adjacent to it are also occupied, the seat becomes empty.
#Otherwise, the seat's state does not change.

seats = []

with open('eleven.txt') as f:
    seats = [list(line.strip()) for line in f.readlines()]

#print(str(len(seats[0])))

def part1(seats_arr):
    seats = seats_arr
    prev = None
    rowLen = len(seats)
    colLen = len(seats[0])

    while(seats != prev):
        prev = copy.deepcopy(seats)
        for row in range(0, rowLen):
            for col in range(0, colLen):
                if prev[row][col] == '.':
                    continue
                else:
                    occupied = 0
                    for x, y in product([-1, 0, 1], repeat = 2):
                        #avoid boundary checks by buffering seats with a border of floors
                        if row + x == row and col + y == col:
                            continue
                        if row + x < 0 or row + x >= rowLen:
                            continue
                        if col + y < 0 or col + y >= colLen:
                            continue
                        if prev[row + x][col + y] == '#':
                            occupied += 1

                    if prev[row][col] == 'L' and occupied == 0:
                        seats[row][col] = '#'

                    if prev[row][col] == '#' and occupied >= 4:
                        seats[row][col] = 'L'
                            
    return sum(r.count('#') for r in seats)


def part2(seats_arr):
    seats = seats_arr
    prev = None
    rowLen = len(seats)
    colLen = len(seats[0])

    while(seats != prev):
        prev = copy.deepcopy(seats)
        for row in range(0, rowLen):
            for col in range(0, colLen):
                if prev[row][col] == '.':
                    continue
                else:
                    occupied = 0
                    for x, y in product([-1, 0, 1], repeat = 2):
                        adj_row = row + x
                        adj_col = col + y
                        while True:
                            if adj_row == row and adj_col == col:
                                break
                            if adj_row < 0 or adj_row >= rowLen:
                                break
                            if adj_col < 0 or adj_col >= colLen:
                                break
                            if prev[adj_row][adj_col] == '#':
                                occupied += 1
                                break
                            if prev[adj_row][adj_col] == 'L':
                                break
                            adj_row += x
                            adj_col += y

                    if occupied == 0:
                        seats[row][col] = '#'

                    if occupied >= 5:
                        seats[row][col] = 'L'
                    
                
    return sum(r.count('#') for r in seats)

print(str(part2(seats)))
        