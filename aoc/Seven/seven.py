import re

containedIn = {}
TO_SEARCH = 'shiny gold'


with open('seven.txt') as f:
    for line in f:
        split_line = line.split("contain")
        outer = re.search(r"\w+ \w+", split_line[0]).group()
        # print(outer)
        inner = re.findall(r"(\d) (\w+ \w+)", split_line[1])
        # print(inner)
        for count, color in inner:
            if containedIn.get(color) == None:
                containedIn[color] = set()
                containedIn[color].add(outer)
            else:
                containedIn[color].add(outer)
print(containedIn)


def bfs(source):
    contains_source = set()
    q = []
    q.append(source)
    while q:
        current = q.pop(0)
        if containedIn.get(current) != None:
            for bag in containedIn[current]:
                if bag not in contains_source:
                    contains_source.add(bag)
                    q.append(bag)
            #print(q)
            #print(contains_source)
        else:
            continue
    return contains_source


print(len(bfs(TO_SEARCH)))
