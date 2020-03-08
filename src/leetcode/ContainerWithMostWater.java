package leetcode;
/*11. Container With Most Water*/

class ContainerWithMostWater{
    public static void main(String[] args) {
        int a[]={1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(c.maxArea(a));
    }

    public int maxArea(int[] height) {
        if(height==null)
            return 0;
        int len = height.length;
        if(len==0)
            return 0;
        int left = 0;
        int right = len-1;
        int area=0;
        while(left<right){
            int h= Math.min(height[left],height[right]);
            int b = right-left;
            area= Math.max(area,h*b);
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return area;
    }

}
