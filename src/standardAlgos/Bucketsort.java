package standardalgos;
import java.util.List;
import java.util.LinkedList;

class Bucketsort {
    public static void main(String[] args) {
        int seq[] = { 99, 78, 67, 123, 245, 368, 144, 60 };
        int digits = findMaxDigits(seq);
        bucketsort(seq, digits);
        for (int i : seq) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static int findMaxDigits(int seq[]) {
        int max = seq[0];
        for (int i : seq) {
            if (i > max)
                max = i;
        }
        int digits = 0;
        while (max != 0) {
            max = max / 10;
            digits++;
        }
        return digits;
    }

    public static void bucketsort(int seq[], int digits) {
        int n = seq.length;
        
        for (int d = 0; d < digits; d++) {
            List<Integer> buckets[] = new LinkedList[10];
            for (int i=0;i<10;i++){
                buckets[i]=new LinkedList<Integer>();
            }
            int mod = 10;
            int div = (int) Math.pow(10, d);
            for (int num : seq) {
                int bucketIndex = (num / div) % mod;
                buckets[bucketIndex].add(num);
            }

            int currIndex = 0;
            
            for (List<Integer> list : buckets) {
                for (int num : list) {
                    seq[currIndex++] = num;
                }
            }
        }
    }
}
