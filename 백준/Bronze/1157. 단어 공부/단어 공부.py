import sys
str = (sys.stdin.readline()).upper().strip()
dic = {}

for c in str:
    if dic.get(c) == None:
        dic[c] = 1
    else:
        dic[c] += 1

max = -4
key = ''
for k in dic:
    if dic[k] > max:
        max = dic[k]
        key = k
    elif dic[k] == max:
        key = '?'

print(key)
     