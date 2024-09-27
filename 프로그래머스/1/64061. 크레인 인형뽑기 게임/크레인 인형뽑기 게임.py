import sys
input = sys.stdin.readline

def solution(board, moves):
    stack = []
    h = len(board)
    answer = 0
    
    for pos in moves:
        for i in range(h):
            if board[i][pos-1] == 0:
                continue
            
            doll = board[i][pos-1]
            board[i][pos-1] = 0
            if stack and stack[-1]==doll:
                stack.pop()
                answer += 2
            else:
                stack.append(doll) 
            break
        
    return answer
