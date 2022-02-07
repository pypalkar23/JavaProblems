
def findMin(nums: List[int]) -> int:
        if(nums[0]<=nums[-1]):
            return nums[0]
        low  = 0
        high = len(nums)-1
        while low<high:  
            mid = low + (high-low)//2
            if (nums[mid] >= nums[high]):
                low = mid + 1
            else:
                high = mid
        return nums[low]


print(findMin([4,5,6,7,0,1,2,3]))