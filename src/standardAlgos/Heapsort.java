class HeapSort{
    public static void main(String[] args) {
        int seq[] = { 8, 10, 3, 2, 0 };
        heapsort(seq);
        for (int i : seq) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void heapsort(int seq[]){
        int n= seq.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(seq, n, i);
        }

        for(int i=n-1;i>=1;i--){
            int temp=seq[0];
            seq[0]=seq[i];
            seq[i]=temp;
            heapify(seq, i, 0);
        }
    }

    public static void heapify(int seq[],int end,int start){
        int left = 2*start+1;
        int right= 2*start+2;
        int largest = start;

        if(left<end && seq[left]>seq[largest]){
            largest=left;
        }
        if(right<end && seq[left]>seq[largest]){
            largest=right;
        }

        if(start!=largest){
            int temp= seq[largest];
            seq[largest]=seq[start];
            seq[start]=temp;
            heapify(seq, end, largest);
        }
    }
}