package leetcode;
class searchRangeCl {
    public int[] searchRange(int[] nums, int target) {
       if(nums==null)
           return new int[]{-1,-1};
        int len= nums.length;
        if(len==0)
            return new int[]{-1,-1};
        int start = 0;
        int end= len-1;
        int result[]=binarysearch(nums, start, end, target);
        return result;
    }
    
    public int[] binarysearch(int nums[],int start,int end,int target){
        int indexes[]= {-1,-1};
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                indexes[0]=mid;
                indexes[1]=mid;
                System.out.println(mid);
                int leftend[] = binarysearch(nums,start,mid-1,target);
                int rightend[] = binarysearch(nums,mid+1,end,target);
                if(leftend[0]!=-1 && leftend[0]<indexes[0])
                    indexes[0]=leftend[0];
                if( rightend[1]!=-1 && rightend[1]>indexes[1])
                    indexes[1]=rightend[1];
                return indexes;
            }
            else if(target<nums[mid]){
                end  = mid-1;
            }
            else{
                start = mid+1;
            }    
        }

        return indexes;
    }
    
    
    public static void main(String[] args) {
        int a[]={5,7,7,8,8,10};
        searchRangeCl scl = new searchRangeCl();
        int ans[]=scl.searchRange(a, 6);
        for (int i: ans){
            System.out.println(i);
        }
    }
}