def solution(prices):
    i = 0
    n = len(prices)
    maxSell = prices[n-1]
    maxDiff =  0
    j = n-2
    for i in range(n-2,-1,-1):
        print(i)
        if prices[i] > maxSell:
            maxSell = prices[i]
        else:
            maxDiff = max(maxDiff, maxSell - prices[i])
    
    return maxDiff


print(solution([7,1,5,3,6,4]))

print(solution([7,6,4,3,2,1]))

        

        
        
