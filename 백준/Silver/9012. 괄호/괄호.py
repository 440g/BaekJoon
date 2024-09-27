import sys
input = sys.stdin.readline

def VPS(PS):
    stack = []
    
    for c in PS:
        if c == '(':
            stack.append(c)
            continue
        if not (stack):
            return False
        else:
            if (stack[-1]=='('):
                stack.pop()
                continue
        stack.append(c)

    if stack:
        return False
    return True

def solution(n):
    for i in range(n):
        PS = input().strip()
        if ('(' not in PS) or (')' not in PS):
            print("NO")
            continue
        if VPS(PS):
            print("YES")
            continue
        print("NO")
    return

if __name__ == '__main__':
    n = int(input())
    solution(n)