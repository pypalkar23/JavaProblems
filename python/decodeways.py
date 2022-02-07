def uniquePaths(m,n):
    helper = [[0 for _ in range(0,n)] for _ in range(0,m)]

    for i in range(n):
        helper[0][i] = 1
    
    for i in range(m):
        helper[i][0] = 1

    for i in range(1,m):
        for j in range(1,n):
            helper[i][j] = helper[i-1][j] + helper[i][j-1]
    
    return (helper[m-1][n-1])

    
print(uniquePaths(3,7))
    
