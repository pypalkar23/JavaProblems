def threeSum(nums):
    if (len(nums)<3):
        return []
    ans = []
    n = len(nums)
    nums.sort()
    for i in range(0,n-2):
        if(i>0 and nums[i]==nums[i-1]):
            continue
        curr = nums[i]
        j = i+1
        k = n-1
        while(j<k):
            if (j>1 and nums[j]==nums[j-1]):
                j += 1
            elif (k<n-1 and nums[k]==nums[k+1]):
                k -= 1
            else: 
                sum = nums[j]+nums[k]+curr
                if sum == 0:
                    ans.append([curr,nums[j],nums[k]])
                    j += 1
                elif(sum<0):
                    j += 1
                else:
                    k -= 1
        
    return ans


print(threeSum([-1,0,1,2,-1,-4]))
print(threeSum([]))
print(threeSum([0]))
print(threeSum([0,0,0,0]))
print(threeSum([1,-1,-1,0]))

            
