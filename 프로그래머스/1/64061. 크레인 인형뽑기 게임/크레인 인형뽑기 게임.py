import sys 
input = sys.stdin.readline

def solution(board, moves):
    answer = 0
    h = len(board)
    moves_cnt = len(moves)
    basket = []
    
    for i in range(moves_cnt):
        pos = moves[i]-1
        for j in range(h):
            if board[j][pos] == 0:
                continue
            doll = board[j][pos]
            board[j][pos] = 0
            
            if (basket) and (doll == basket[-1]):
                basket.pop()
                answer += 2
            else:
                basket.append(doll)
            break
    
    return answer