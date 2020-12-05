maxID = 0

def process(line):
    row = line[0:7].replace('F', '0').replace('B', '1')
    col = line[7:10].replace('L', '0').replace('R', '1')
    seatID = int(row, 2) * 8 + int(col, 2)
    #print(str(seatID) + "\n")
    return seatID

with open('five.txt') as f:
    for line in f:
        maxID = max(maxID, process(line))

print(str(maxID))

