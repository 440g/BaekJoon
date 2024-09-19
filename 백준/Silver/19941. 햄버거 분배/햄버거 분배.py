import sys
input = sys.stdin.readline

def sol(n, k, s):
    l = list(s)
    max = 0
    length = len(l)
    
    for i in range(length):
        if l[i] != 'P':
            continue
        
        for j in range(i-k, i):
            if j >= 0 and l[j] == 'H':
                max += 1
                l[j] = 'X'
                l[i] = 'O'
                break
    
        if l[i] != 'O':
            for j in range(i+1, i+k+1):
                if j < length and l[j] == 'H':
                    max += 1
                    l[j] = 'X'
                    break  
    
    return max

if __name__ == '__main__':
    n, k = map(int, input().split())
    s = input().strip()
    print(sol(n, k, s))
    