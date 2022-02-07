#53. Maximum Subarray

def maxSubArray(nums):
    sum = 0
    maxSum = 0
    for num in nums:
        sum += num
        if sum > maxSum:
            maxSum = sum
        
        if sum < 0:
            sum = 0

    return maxSum




print(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))