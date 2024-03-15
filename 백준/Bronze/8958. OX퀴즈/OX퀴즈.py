import sys
i = int(sys.stdin.readline())

for i in range(0, i):
    str = sys.stdin.readline()
    score = 0
    plus = 1
    prev = False
    
    for j in str:
        if(j=='X'):
            prev = False
        elif(j=='O'):
            if(prev):
                plus += 1
            else:
                plus = 1
            score += plus
            prev = True
            
    print(score)