from typing import AnyStr


def maxProduct(nums):
    maxProduct = 1
    minProduct = 1
    ans =  max(nums)
    for num in nums:
        if num == 0:
            minProduct, maxProduct = 1,1 
        currMax = num * maxProduct        
        maxProduct = max(num * maxProduct, num * minProduct, num)
        minProduct = min(currMax, num* minProduct, num) 
        ans = max(minProduct,maxProduct,ans)

    return ans

print(maxProduct([2,3,-2,4]))
