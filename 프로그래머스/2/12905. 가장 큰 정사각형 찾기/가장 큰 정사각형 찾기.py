import sys
input = sys.stdin.readline

def solution(board):
    answer = 0
    row = len(board) + 1
    col = len(board[0]) + 1
    dp = [[0] * col] * row
    
    for i in range(1, row):
        for j in range(1, col):
            if board[i-1][j-1]:
                dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
            answer = max(answer, dp[i][j])

    return answer ** 2
