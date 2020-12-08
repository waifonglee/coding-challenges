class Ins:
    def __init__(self, name, num, term):
        self.name = name
        self.num = num
        self.term = term


ins_arr = []

with open('eight.txt') as f:
    for line in f:
        split_line = line.strip().split(" ")
        ins_arr.append(Ins(split_line[0], int(split_line[1]), -1))

def p1():
    acc = 0
    executed = set()
    ind = 0
    while True:
        current_ins = ins_arr[ind]
        if current_ins in executed:
            return acc
        else:
            executed.add(current_ins)
            ins = current_ins.name
            count = current_ins.num
            if ins == 'nop':
                ind += 1
            elif ins == 'jmp':
                ind += count
            else:
                acc += count
                ind += 1
    
print(p1())

def check(i, executed):
    if i >= len(ins_arr):
        return 1
    ins = ins_arr[i]
    if ins.term != -1:
        return ins.term
    else:
        if ins in executed:
            ins.term = 0
            return 0
        else:
            executed.add(ins)
            name = ins.name
            count = ins.num
            ind = i
            if name == 'nop':
                ind += 1
            elif name == 'jmp':
                ind += count
            else:
                ind += 1

            ins.term = check(ind, executed)
            return ins.term

def accumulate(ind, ac):
    acc = ac
    i = ind
    while i < len(ins_arr):
        current_ins = ins_arr[i]
        ins = current_ins.name
        count = current_ins.num
        if ins == 'nop':
            i += 1
        elif ins == 'jmp':
            i += count
        else:
            acc += count
            i += 1
    return acc

def p2():
    acc = 0
    ind = 0
    executed = set()
    while True:
        current_ins = ins_arr[ind]
        if current_ins in executed:
            print("fail")
            break
        else:
            ins = current_ins.name
            count = current_ins.num
            if ins == 'nop':
                if check(ind + count, set()) == 1:
                    print("found at " + ins_arr[ind + count].name + str(ins_arr[ind + count].num))
                    print(str(accumulate(ind + count, acc)))
                    break
                else:
                    ind += 1   
                    
            elif ins == 'jmp':
                if check(ind + 1, set()) == 1:
                    print("found at " + ins_arr[ind + 1].name + str(ins_arr[ind + 1].num))
                    print(str(accumulate(ind + 1, acc)))
                    break
                else:
                    ind += count 
            else:
                acc += count
                ind += 1


p2()
#p2 done using memoisation 
    



