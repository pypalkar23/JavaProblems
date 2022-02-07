import java.util.ArrayList;

public class MemoryAlloc {
    static int atomic_counter = 1;
    static ArrayList<String> positions = new ArrayList<>();

    static int erase(int id, int a[]) {
        if (id > positions.size() || id <= 0) {
            return -1;
        }
        String pos = positions.get(id - 1);
        int retval = 0;
        if (pos.equals("deleted")) {
            return -1;
        }

        if (pos.length() == 1) {
            int index = Integer.parseInt(pos); 
            a[index] = 0;
            retval = 1;
            positions.set(id - 1, "deleted");
        } else if (pos.length() == 2){
            int begin = Integer.parseInt(String.valueOf(pos.charAt(0)));
            int end = Integer.parseInt(String.valueOf(pos.charAt(1)));
            retval = (end - begin) + 1;
            for (int i = begin; i <= end; i++)
                a[i] = 0;
            positions.set(id - 1, "deleted");
        }
        return retval;
    }

    static int alloc(int x, int a[]) {
        int retval = -1;
        if (x == 1) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 0) {
                    a[i] = 1;
                    atomic_counter++;
                    positions.add(String.valueOf(i));
                    retval = i;
                    break;
                }

            }

        }
        // beginning of block
        int begin = 0;
        // end of the block
        int end = 0;
        // count of continious block
        int count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (count == 0) {
                begin = i;

            } else if (count == x - 1) {
                end = i;
                retval = begin;
                String pos = String.valueOf(begin) + String.valueOf(end);
                positions.add(pos);
                atomic_counter++;
                break;
            }

            if (a[i] == 0 && a[i + 1] == 0) {
                count++;
            } else
            {
                count = 0;
            }
        }
        for (int i = begin; i <= end; i++)
            a[i] = 1;

        return retval;
    }

    static int[] memoryAllocator(int a[], int queries[][]) {
        int retarr[] = new int[queries.length];
        int index = 0;

        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) {
                int retval = alloc(queries[i][1], a);
                retarr[index] = retval;
                index++;

            } else if (queries[i][0] == 1) {
                int retval = erase(queries[i][1], a);
                retarr[index] = retval;
                index++;
            }
        }
        return retarr;
    }

    public static void main(String[] args) {
        int a[] = { 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0 };
        int queries[][] = { { 0, 2 }, { 0, 1 }, { 0, 1 }, { 1, 2 }, { 1, 4 }, { 0, 4 } };
        int ans[] = memoryAllocator(a, queries);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
