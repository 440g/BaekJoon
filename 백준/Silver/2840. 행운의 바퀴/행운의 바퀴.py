import sys
input = sys.stdin.readline

N, K = map(int, input().split())
w = ['?'] * N
index = 0
isExist = True

for i in range(K):
    S, C = map(str, sys.stdin.readline().rstrip().split()) 
    index = (index + N - int(S)) % N
    if (w[index] != C) & (w.count(C) != 0):
       isExist = False
       break; 
    if w[index] == '?':
       w[index] = C
    elif w[index] != C:
        isExist = False
        break;
    

if isExist==False:
    print("!")
else:
    print(''.join(w[index:] + w[:index]))