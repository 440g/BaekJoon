import sys
from heapq import *

h = []
n = int(sys.stdin.readline())
for i in range(0, n):
    n = int(sys.stdin.readline())
    if n != 0:
        heappush(h, -n)
    else:
        if len(h) == 0:
            print(0)
        else:
            print(-heappop(h))