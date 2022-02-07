def climbStairs(n):
    helper = [0] * (n+1)
    helper[1] = 1
    helper[2] = 2

    for i in range(3,n+1):
        helper[i] = helper[i-1]+ helper[i-2]
    
    return helper[n]
    
print(climbStairs(5))
