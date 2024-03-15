import sys
numList = []

for i in range(10):
    n = int(int(sys.stdin.readline()) % 42)
    if(numList.count(n) == 0):
        numList.append(n)

print(len(numList))