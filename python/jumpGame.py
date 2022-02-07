def canJump(nums):
    maxReach = nums[0]
    for i in range(1,len(nums)):
        if(maxReach<i):
            return False
        maxReach = max(nums[i]+i,maxReach)
    return True

print(canJump([2,3,1,1,4]))
print(canJump([3,2,1,0,4]))
    