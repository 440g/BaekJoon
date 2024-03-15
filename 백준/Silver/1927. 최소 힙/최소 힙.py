from heapq import *
import sys
h = []
inp = int(sys.stdin.readline())
for i in range(0, inp):
    n = int(sys.stdin.readline())
    if n != 0:
        heappush(h, n)
    else:
        if len(h) == 0:
            print(0)
        else:
            print(heappop(h))