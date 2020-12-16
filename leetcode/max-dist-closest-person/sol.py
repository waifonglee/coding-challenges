#You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in 
# the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).
# There is at least one empty seat, and at least one person sitting.
# Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 
# Return that maximum distance to the closest person.

class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        occupied = []
        occupied.append(-10**5)
        for i in range(0, len(seats)):
            if seats[i] == 1:
                occupied.append(i)
        occupied.append(10**5)
        #print(occupied)
        
        left = 0
        maxD = 0
        right = 1

        for j in range(0, len(seats)):
            if j > occupied[right]:
                left += 1
                right += 1
            if seats[j] == 1:
                continue
            else:
                maxD = max(maxD, min(j - occupied[left], occupied[right] - j))
                
        return maxD
#i guess we can also deal with only occupied seats, 
#i.e the largest dist comes from between occupied seats so just min (mid dist between 2 occupied seats)               