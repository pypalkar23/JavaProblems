def search(nums,target) -> int:
    low = 0
    high = len(nums)-1
    while low< high:
        mid = low + (high-low)//2
        if (nums[mid]==target):
            return mid
       

    
    return -1

print(search([4,5,6,7,0,1,2],0))