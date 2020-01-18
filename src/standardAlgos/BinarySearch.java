package standardalgos;
class BinarySearch
{
    public static void main(String[] args) {
        int a[]={0,1,2,3,4,5,6};
        int n=7;
        int low=0;
        int high=n-1;
        int find=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(a[mid]==find){
                System.out.println("Found");
                return;
            }
            else{
                if(find<a[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
        }
        System.out.println("Not found");
        
    }
}