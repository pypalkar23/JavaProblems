package standardalgos;
class QuickSort{
    public static void main(String[] args) {
        int seq[] = { 8, 9, 3, -1, 0 };
        quicksort(seq,0,4);
        for (int i : seq) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static int partition(int seq[],int start,int end){
        int pivot = seq[end];
        int i=start-1;
        for(int j=start;j<end;j++){
            if(seq[j]<=pivot){
                i++;
                int temp=seq[j];
                seq[j]=seq[i];
                seq[i]=temp;
            }
        }
        int temp=seq[i+1];
        seq[i+1]=seq[end];
        seq[end]=temp;
        return i+1;
    }

    public static void quicksort(int seq[],int start,int end) {
        if(start<end){
           int p= partition(seq, start, end); 
           quicksort(seq, start, p-1);
           quicksort(seq, p+1, end);
        }
    }
}