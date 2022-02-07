def coinChange(coins,target):
    helper = [float("inf")]*(target+1)
    helper[0] = 0 
    for i in range(1,target+1):
        for j in coins:
            if( j <= i):
                past_coins = helper[i-j] 
                if past_coins != float("-inf") and past_coins+1 < helper[i]:
                    helper[i]= past_coins+1
        print(helper)
        

    
    return(helper[target])


print(coinChange([1,2,5],11))

    