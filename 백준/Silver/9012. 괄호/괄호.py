import sys
input = sys.stdin.readline

def solution(PS):
    VPS = []
    
    for i in range(len(PS)):
        pop = PS[i]
        if pop == '(':
            VPS.append(pop)
            continue
        
        if VPS and (pop!=VPS[-1]):
             VPS.pop()
        else:
            VPS.append(pop)
    
    if VPS:
        print("NO")
    else:
        print("YES")
    return

if __name__ == '__main__':
    for i in range(int(input())): 
        solution(input().strip())