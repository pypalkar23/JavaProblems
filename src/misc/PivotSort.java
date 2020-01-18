package misc;
class PivotSort {
    public static void main(String[] args) {
        int a[]=new int[]{0,0,1,1,0};
        pivotSort(a);
        for (int i:a){
            System.out.println(i+" ");
        }
    }

    public static void pivotSort(int a[]){
        if (a==null)
            return;
        int n = a.length;

        int i=0,j=n-1;
        while(i<j){
            if(a[i]>a[j]){
                int temp = a[i];
                a[i]=a[j];
                a[j] = temp;
                j--;
            }
            i++; 
        }
    }
}

