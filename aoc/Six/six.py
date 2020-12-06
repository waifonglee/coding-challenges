def proc_1():
    num = 0
    qns = set()
    with open('six.txt') as f:
        for line in f:
            if line != '\n':
                for c in line:
                    if c != '\n':
                        qns.add(c)
                #print(qns)
            else:
                num = num + len(qns)
                #print(str(len(qns)))
                #print(str(num))
                qns.clear()
    return num + len(qns)

num = proc_1()
print(str(num))
