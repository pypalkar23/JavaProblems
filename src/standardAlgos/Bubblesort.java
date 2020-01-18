
class Bubblesort {
    public static void main(String[] args) {
        int seq[] = { 8, 9, 3, -1, 0 };
        bubblesort(seq);
        printArray(seq);
    }

    public static void printArray(int seq[]){
        for (int i : seq) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }    
    public static void bubblesort(int seq[]) {
        int n = seq.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (seq[j] > seq[j + 1]) {
                    int temp = seq[j];
                    seq[j] = seq[j + 1];
                    seq[j + 1] = temp;
                }
            }
            printArray(seq);
        }
    }
}
