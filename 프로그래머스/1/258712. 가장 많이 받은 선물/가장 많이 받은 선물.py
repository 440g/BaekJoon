def solution(friends, gifts):
    n = len(friends)
    d = dict()
    gives = [[0] * n for _ in range(n)]
    giftScore = [0] * n
    giftProm = [0] * n
    
    for i in range(n):
        d[friends[i]] = i
    
    for i in range(len(gifts)):
        a, b = gifts[i].split()
        a = d[a]
        b = d[b]
        
        gives[a][b] += 1
        giftScore[a] += 1
        giftScore[b] -= 1
    # 초기화 
        
    for i in range(n):
        for j in range(n):
            if i==j:
                continue
            
            if gives[i][j] > gives[j][i]:
                giftProm[i] += 1
            elif (gives[i][j] == gives[j][i]) and (giftScore[i] > giftScore[j]):
                giftProm[i] += 1 
                
    return max(giftProm)