package standardalgos;
class SelectionSort {
    public static void main(String[] args) {
        int seq[] = { 1,9,5,3,4 };
        selectionSort(seq);
        for (int i : seq) {
            System.out.print(i + " ");
        }
        System.out.println("");

        printArray(seq);
    }

    public static void selectionSort(int seq[]) {
        int n = seq.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (seq[j] < seq[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = seq[i];
                seq[i] = seq[min];
                seq[min] = temp;
            }
            printArray(seq);
        }
    }

    public static void printArray(int seq[]){
        for (int i : seq) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }  
}