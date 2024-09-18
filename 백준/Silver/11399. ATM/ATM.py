import sys
input = sys.stdin.readline

def sol(t):
    t.sort()
    a = 0
    p = 0
    
    
    for i in t:
        p += i
        a += p
    
    return a

if __name__ == "__main__":
    n = int(input().strip())
    t = list(map(int, input().split()))
    print(sol(t))