with open('ten.txt') as f:
    adapters = sorted([int(line.strip()) for line in f])
    adapters.insert(0, 0)
    adapters.append(adapters[len(adapters)- 1] + 3)
#print(adapters)

def p1():
    diff_one = 0
    diff_three = 0
    
    for i in range(0, len(adapters) - 1):
        if adapters[i + 1] - adapters[i] == 1:
            diff_one += 1
        elif adapters[i + 1] - adapters[i] == 3:
            diff_three += 1
    
    return diff_one * (diff_three + 1)

#print(str(p1()))
memo = {}
#either use global or pass the memo dict into argument

def num_of_ways(i):
    global memo
    if memo.get(i) != None:
        return memo[i]
    
    if i == len(adapters) - 1:
        return 1

    num = 0
    current = adapters[i]
    for j in range(i + 1, len(adapters)):
        if adapters[j] - current <= 3:
            num += num_of_ways(j)
        else:
            break

    memo[i] = num
    return num
    

print(str(num_of_ways(0)))




