import sys
from collections import Counter 
input = sys.stdin.readline

def sol(s):
    l = sorted(Counter(s).items())
    a = ""
    mid = ""
    
    for alphabet, num in l:
        if num%2 == 1:
            if len(mid) != 0:
                return "I'm Sorry Hansoo"
            mid = alphabet
        a += alphabet * (num//2)    
        
    return a + mid + a[::-1]

if __name__ == "__main__":
    s = input().strip()
    print(sol(s))