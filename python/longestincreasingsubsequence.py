def longestIncreasingSubsequence(nums):
    helper = [1] * len(nums)
    max = 1
    for i in range(1,len(nums)):
        for j in range(0,i):
            if(nums[i]>nums[j] and helper[j]+1>helper[i]):
                helper[i] = helper[j]+1
                if helper[i]>max:
                    max = helper[i]
    
    return max


print(longestIncreasingSubsequence([10,9,2,5,3,7,101,18]))
print(longestIncreasingSubsequence([0,1,0,3,2,3]))
print(longestIncreasingSubsequence([7,7,7,7,7,7,7]))
                
    
    
