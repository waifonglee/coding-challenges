inst = []
with open('input.txt') as f:
    inst = [line.strip() for line in f]
#print(inst)

def p1(inst):
    i = 0
    done = {}
    total = 0
    mask = ''
    while i < len(inst):
        currentIns = inst[i]
        if currentIns[0:4] == 'mask':
            mask = currentIns.split('=')[1].strip()
        else:
            split_string = currentIns.split('=')
            binary_val = [c for c in bin(int(split_string[1].strip())).replace("0b", "").zfill(36)]
            memory = split_string[0].strip()
            ind = int(memory[4:len(memory) - 1])
            if ind in done:
                total -= done[ind]
            
            for m in range(len(mask)):
                if mask[m] != 'X':
                    binary_val[m] = mask[m]
        
            decimal_val = int(''.join(binary_val), 2)
            done[ind] = decimal_val
            total += decimal_val
        i+=1
    
    return total


            

print(str(p1(inst)))