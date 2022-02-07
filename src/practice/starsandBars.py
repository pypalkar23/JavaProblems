def starsAndBars(s,startIndex,endIndex):
    dp= [0]*len(s)
    result=[]

    firstBar = (s[0]=='|')
    starsCount = 0
    for i in range(1,len(s)):
        if(not firstBar and s[i]=='|'):
            firstBar = True
        elif(firstBar and s[i]=='|'):
            dp[i]=dp[i-1]+starsCount
            starsCount = 0
        elif(firstBar and s[i]=='*'):
            starsCount +=1
            dp[i] = dp[i-1]
    print(dp)
    for i in range(len(startIndex)):
        result.append(dp[endIndex[i]-1]-dp[startIndex[i]-1])
    
    return result

print(starsAndBars("|**|****|**|*",[1,3],[9,12]))
print(starsAndBars("*|**|*|",[1],[6]))
print(starsAndBars("*|*",[1],[3]))
      
