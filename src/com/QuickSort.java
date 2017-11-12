package com;
class QuickSort
{
    public static void main(String[] args) {
        int a[]={10,9,8,7,6};
        int n=5;
        quicksort(a, 0, n-1);
        for(int i:a)
            System.out.println(i+" ");
    }

    public static int partition(int a[],int l,int h)
    {
        int pivot=a[h];
        int i=l-1;
        for(int j=l;j<=h-1;j++){
            if(a[j]<=pivot){
                i++;
                int temp=a[j];
                a[j]=a[i];
                a[i]=temp; 
            }
        }
        int temp=a[i+1];
        a[i+1]=a[h];
        a[h]=temp;
        return i+1;
    }

    public static void quicksort(int a[],int low,int high)
    {
        if(low<high)
        {
            int p=partition(a, low, high);
            quicksort(a, low, p-1);
            quicksort(a, p+1, high);
        }
    }
}