    import java.util.*;

    class TotalCost {
        public static void finalPrice(List<Integer> prices) {
            // Write your code here
            int n= prices.size();
            int[] modifiedPrizes = new int[n];
            for (int i = 0; i < n; i++) {
                modifiedPrizes[i] = prices.get(i);
            }
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!s.isEmpty() && prices.get(s.peek()) >= prices.get(i)){
                    int pre = s.pop();
                    modifiedPrizes[pre] = prices.get(pre) - prices.get(i);
                }
                s.push(i);
            }
            long res = 0;
            List<Integer> nonDiscountItems= new ArrayList<Integer>();
            for(int i=0;i<n ;i++){
                res+=modifiedPrizes[i];
                if(modifiedPrizes[i]==prices.get(i))
                nonDiscountItems.add(modifiedPrizes[i]);
            }
            System.out.println(res);
            for(int i:nonDiscountItems)
                System.out.println(i+" ");
            
        }
    }