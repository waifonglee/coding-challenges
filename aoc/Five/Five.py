maxID = 0
minID = 1024
seats = set()

def process(line):
    row = line[0:7].replace('F', '0').replace('B', '1')
    col = line[7:10].replace('L', '0').replace('R', '1')
    seatID = int(row, 2) * 8 + int(col, 2)
    #print(str(seatID) + "\n")
    return seatID

## pt 1
#with open('five.txt') as f:
#    for line in f:
#        seatID = process(line)
#        maxID = max(maxID, seatID)
#print(str(maxID))

with open('five.txt') as f:
    for line in f:
        seatID = process(line)
        maxID = max(maxID, seatID)
        minID = min(minID, seatID)
        seats.add(seatID)

for i in range(minID, maxID):
    if i not in seats:
        print(str(i))
        break


