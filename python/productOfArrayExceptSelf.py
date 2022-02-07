#238. Product of Array Except Self
def productOfArrayExceptSelf(nums):
    n = len(nums)
    helper = [0]*n
    
    left = 1
    helper[0] = 1
    for i in range(1,n):
        helper[i] = left * nums[i-1]
        left = helper[i]
    
    
    
    right = 1
    for i in range(n-2,-1,-1):
        right = right * nums[i+1]
        helper[i] = right * helper[i]
        
#1,2,3,4
#1,1,2,6,1

    return helper



print(productOfArrayExceptSelf([1,2,3,4]))
print(productOfArrayExceptSelf([4,3,2,1,2]))
