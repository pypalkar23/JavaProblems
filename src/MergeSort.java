class MergeSort
{
    public static void main(String[] args) {
        int a[]={13,9,8,11,-5};
        int n=5;
        mergesort(a, 0, n-1);
        for(int i:a)
        {
            System.out.print(i+" ");
        }
        System.out.println("");
    }   

    public static void simpleMerge(int a[],int start,int last,int mid)
    {
        int l=start;
        int m=mid+1;
        int r=last;
        int temp[]=new int[r-l+1];
        int k=0;
        
        while(l<=mid && m<=last)
        {
            if(a[l]<=a[m])
            {
             temp[k++]=a[l++];  
            }
            else
            {
              temp[k++]=a[m++];  
            }
        }

        while(l<=mid)
        {
            temp[k++]=a[l++];  
        }
        while(m<=last)
        {
            temp[k++]=a[m++];
        }

        for(int i=0;i<k;i++)
        {
            a[start+i]=temp[i];
        }
    }

    public static void mergesort(int a[],int l,int r)
    {
        int mid=0;
        if(l<r)
        {
            mid=(l+r)/2;
            mergesort(a, l, mid);
            mergesort(a, mid+1, r);
            simpleMerge(a, l, r, mid);
        }   
           
        
    }
}