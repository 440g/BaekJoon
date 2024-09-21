import sys
input = sys.stdin.readline

def solution(board, n, m):
    dp = [[0]*(m+1) for _ in range(n+1)]
    answer = 0
    
    for i in range(1, n+1):
        for j in range(1, m+1):
            if board[i-1][j-1]:
                dp[i][j] = 1 + min(min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])
            answer = max(answer, dp[i][j])   
    
    return answer**2

if __name__ == '__main__':
    n, m = map(int, input().split())
    # 파이썬 배열입력 자주 헷갈리니까 신경 좀 쓰기
    board = [[int(i) for i in input().strip()] for r in range(n)]
    print(solution(board, n, m))