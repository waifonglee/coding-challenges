def proc_1():
    num = 0
    qns = set()
    with open('six.txt') as f:
        for line in f:
            if line != '\n':
                for c in line:
                    if c != '\n':
                        qns.add(c)
            else:
                num = num + len(qns)
                qns.clear()
    return num + len(qns)


def proc_2():
    num = 0
    qns = {}
    num_people = 0
    with open('six.txt') as f:
        for line in f:
            if line != '\n':
                num_people = num_people + 1
                for c in line:
                    if c != '\n':
                        if qns.get(c) != None:
                            n = qns.get(c)
                            qns[c] = n + 1
                        else:
                            qns[c] = 1
            else:
                for v in qns.values():
                    if v == num_people:
                        num = num + 1
                num_people = 0
                qns.clear()

    for v in qns.values():
        if v == num_people:
            num = num + 1
    return num


num = proc_2()
print(str(num))
