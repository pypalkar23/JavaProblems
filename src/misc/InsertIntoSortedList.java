package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntoSortedList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[] { 1, 2, 5 }));
        int[] numToAdd = new int[] { 10, 11, 13, 12, 13, 15 };
        for (int i : numToAdd) {
            insertIntoSortedList(list, i);
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static void insertIntoSortedList(List<Integer> list, int num) {
        int n = list.size();
        int low = 0;
        int high = n - 1;
        int mid = 0;
        int midnum = list.get(0);
        while (low <= high) {
            mid = (low + high) / 2;
            midnum = list.get(mid);
            if (midnum == num)
                break;
            else if (midnum > num)
                high = mid - 1;
            else
                low = mid + 1;
        }
        midnum = list.get(mid);

        int insertPos = -1;
        if (num < midnum)
            insertPos = Math.max(0, mid);
        else if (num >= midnum)
            insertPos = Math.min(n, mid + 1);

        list.add(insertPos, num);

    }
}
