constraints = {}
my_ticket = []
nearby = []
with open("in.txt") as f:
    for line in f:
        if line != '\n':
            current = line.strip()
            name = line.split(':')[0]
            values = line.split(':')[1].split('or')
            ranges = []
            for x in values:
                split = x.split('-')
                ranges.append((int(split[0].strip()), int(split[1].strip())))
            constraints[name] = ranges
        else:
            break
    for line in f:
        if line.strip() == 'your ticket:':
            continue
        if line != '\n':
            my_ticket.append([int(c) for c in line.strip().split(',')])
        else:
            break
    for line in f:
        if line.strip() == 'nearby tickets:':
            continue
        if line != '\n':
            nearby.append([int(c) for c in line.strip().split(',')])
        else:
            break

#print(constraints)
#print(my_ticket)
#print(nearby)

def errorSum(constraints, ticket):
    for constraint in constraints:
        for x, y in constraints[constraint]:
            if x <= ticket <= y:
                return 0          
    return ticket

def p1(constraints, nearby):
    error_sum = 0
    for ticket in nearby:
        for val in ticket:
            error_sum += errorSum(constraints, val)
    return error_sum

#print(str(p1(constraints, nearby)))

def checkError(constraints, ticket):
    for i in ticket:
        if errorSum(constraints, i) != 0:
            return True
    return False

def discard(constraints, tickets):
    valid = []
    for i in tickets:
        if not checkError(constraints, i):
            valid.append(i)
    return valid


def validConstraint(constraints, ticket, check): #return a list of constraint it satisfies
    valid = []
    for constraint in check:
        if checkConstraint(ticket, constraints[constraint]):
            valid.append(constraint)
    return valid


def checkConstraint(ticket, constraint):
    for x, y in constraint:
            if x <= ticket <= y:
                return True
    return False

def p2(constraints, nearby, myticket):
    validTickets = discard(constraints, nearby)
    p = []
    k = constraints.keys()
    for i in range(0, len(nearby[0])):
        p.append(k)
    for t in validTickets:
        for j in range(0, len(t)):
            p[j] = validConstraint(constraints, t[j], p[j])
    print(p)
    fixed = []
    while len(fixed) < len(k):
        for i in p:
            if len(i) == 1:
                fixed.append(i[0])
            else:
                for x in i:
                    if x in fixed:
                        i.remove(x)
                if len(i) == 1:
                    fixed.append(i[0])
    #print(p)
        

            



p2(constraints, nearby, my_ticket)

