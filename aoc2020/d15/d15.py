#Van Eck's sequence
ums = []
with open("in.txt") as f:
    nums = [n for n in f.readline().strip().split(",")]
#print(nums)

def spoken(turn, nums):
    memo = {}
    current_num = 0
    #print(str(current_num))
    for i in range(0,len(nums)):
        memo[int(nums[i])] = i
    for j in range(len(nums), turn - 1):
        #print("current " + str(current_num))
        #print(memo)
        if current_num not in memo:
            memo[current_num] = j
            current_num = 0
        else:
            new_num = j - memo[current_num]
            #print(str(new_num) + " j: " + str(j))
            memo[current_num] = j
            current_num = new_num #we are already calculating the val of the next spoken num in the prev round, hence stop before turn - 1
    
    return current_num

#print(str(spoken(2020, nums)))
print(str(spoken(30000000, nums)))