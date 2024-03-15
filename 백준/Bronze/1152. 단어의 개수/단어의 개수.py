import sys
str = (sys.stdin.readline()).strip()
if len(str) == 0:
    print(0)
elif len(str) !=0:
    print(str.count(" ") + 1)