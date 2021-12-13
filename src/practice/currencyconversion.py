import sys
from collections import defaultdict
from collections import deque


previous solution
def getRatio(start, end, data):
    dict = defaultdict(list)
    for node in data:
        dict[node[0]].append([ node[1], node[2] ])
        dict[node[1]].append([ node[0], 1.0 / float(node[2]) ])
    queue = deque()
    queue.append((start, 1.0))
    visited = set()
    while queue:
        curr, num = queue.popleft()
        if curr in visited:
            continue  
        visited.add(curr)
        if curr in dict:
            values = dict.get(curr)
            next = {}
            for val in values:
                next[val[0]] = val[1]
            for key in next:
                if key not in visited:
                    if key == end:
                        return num * float(next[key])
                    queue.append((key, num * float(next[key])))
    return -1

Fixed_rate=[]
Original_currency = ""
Target_Currency = ""

ip = input()

output
print(ip)
for entry in ip:
    Fixed_rate.append(entry.split(","))
Original_currency = input()
Target_Currency = input()
print(Fixed_rate)
'''
for i,line in enumerate(sys.stdin):
    if i==0:
        ip = (line.split(“;”))[:-1]
        print(ip)
        for entry in ip:
            Fixed_rate.append(entry.split(“,”))
    if i==1:
        Original_currency = line[:-1]
    if i==2:
        Target_Currency = line[:-1]
'''
print getRatio(Original_Currency, Target_Currency, Fixed_rate)

