import sys

X = (sys.stdin.readline()).strip()
Y = (sys.stdin.readline()).strip()
m = len(X)
n = len(Y)
grid = [[0 for y in range(n+1)] for x in range(m+1)]

for i in range(1, m+1):
    for j in range(1, n+1):
        if(X[i-1]==Y[j-1]):
            grid[i][j] = grid[i-1][j-1] + 1; 
        else:
            grid[i][j] = max(grid[i-1][j], grid[i][j-1])

print(grid[m][n]);

