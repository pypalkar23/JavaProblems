
class InsertionSort {
    public static void main(String[] args) {
        int seq[] = { 8, 9, 3, -1, 0 };
        insertionsort(seq);
        for (int i : seq) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static void insertionsort(int seq[]) {
        int n = seq.length;
        for (int i = 0; i < n-1; i++) {
            int j = i+1;
            while(j-1>=0){
                if(seq[j]<seq[j-1]){
                    int temp = seq[j];
                    seq[j] = seq[j-1];
                    seq[j-1] = temp;
                }
                j--;
            }
        }
    }
}
