# naive solution for part 1 is to just brute force and calculate 2 sum each time using itertools

from itertools import combinations
from collections import deque

int_arr = []
with open('nine.txt') as f:
    int_arr = [int(line.strip()) for line in f]

#print(int_arr)

#brute force :)
def p1(windowLen):
    tar = windowLen
    queue = deque()
    for i in range(0, windowLen):
        queue.append(int_arr[i])
    #print(queue)
    cbs = set(a + b for a, b in combinations(queue, 2))
    while True:
        if int_arr[tar] not in cbs:
            return int_arr[tar]
        else:
            queue.popleft()
            queue.append(int_arr[tar])
            tar += 1
            cbs = set(a + b for a, b in combinations(queue, 2))

def p2():
    invalid_num = p1(25)
    left = 0
    right = 1
    current_sum = int_arr[0] + int_arr[1]

    while True:
        if current_sum < invalid_num: 
            right += 1
            current_sum += int_arr[right]
        elif current_sum > invalid_num:
            current_sum -= int_arr[left]
            left += 1
        else:
            contiguous = int_arr[left:right + 1]
            return min(contiguous) + max(contiguous)
    

print(str(p2()))