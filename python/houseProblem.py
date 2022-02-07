def houseProblem(nums):
    n = len(nums)
    helper = [0]*(n+2)

    for i in range(0,n):
        helper[i+2] = max(helper[i+1],helper[i]+nums[i])
    
    return helper[-1]


print(houseProblem([1,2,3,1]))
