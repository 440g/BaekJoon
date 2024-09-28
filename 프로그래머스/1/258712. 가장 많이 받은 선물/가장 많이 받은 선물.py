import sys
input = sys.stdin.readline

def solution(friends, gifts):
    #초기화
    n = len(friends)
    d = dict()
    give = [[0] * n for _ in range (n)]
    giftscore = [0] * n
    giftpromised = [0] * n
    for i in range (n):
        d[friends[i]] = i
    for i in range(len(gifts)):
        a, b = gifts[i].split()
        a = d[a]
        b = d[b]
        give[a][b] += 1
        giftscore[a] += 1
        giftscore[b] -= 1
        
    # 코드 
    for i in range(n):
        for j in range(n):
            if i == j:
                continue
            
            if give[i][j] > give[j][i]:
                giftpromised[i] += 1
            elif (give[i][j] == give[j][i]) and giftscore[i] > giftscore[j]:
                giftpromised[i] += 1
    
    return max(giftpromised)    
    