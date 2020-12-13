time = 0
buses = []
with open('input.txt') as f:
    time = int(f.readline().strip())
    # part 1:buses = [int(bus) for bus in f.readline().strip().split(",") if bus != 'x']
    buses = [bus for bus in f.readline().strip().split(",")]


def p1(buses, time):
    waitTime = float('inf')
    busID = 0
    for bus in buses:
        current_wait = bus - (time % bus)
        if current_wait < waitTime:
            waitTime = current_wait
            busID = bus
    return waitTime * busID

#print(str(p1(buses, time)))


# Chinese remainder code source from : https://rosettacode.org/wiki/Chinese_remainder_theorem
from functools import reduce
def chinese_remainder(n, a):
    sum = 0
    prod = reduce(lambda a, b: a*b, n)
    for n_i, a_i in zip(n, a):
        p = prod // n_i
        sum += a_i * mul_inv(p, n_i) * p
    return sum % prod
 
def mul_inv(a, b):
    b0 = b
    x0, x1 = 0, 1
    if b == 1: return 1
    while a > 1:
        q = a // b
        a, b = b, a%b
        x0, x1 = x1 - q * x0, x0
    if x1 < 0: x1 += b0
    return x1
 
#Chinese remainder theorem
def p2(buses):
    # x = a mod n
    n = []
    a = []
    for i in range(0, len(buses)):
        if buses[i] == 'x' :
            continue
        n.append(int(buses[i]))
        a.append(int(buses[i]) - i)
    
    return chinese_remainder(n, a)

print(str(p2(buses)))


