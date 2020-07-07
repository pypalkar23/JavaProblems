package leetcode;
class Multiply {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null)
            return "0";
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int first[] = new int[num1.length()];
        int second[] = new int[num2.length()];
        for (int i = 0, n = num1.length(); i < n; i++)
            first[i] = Character.getNumericValue(num1.charAt(i));
        for (int i = 0, n = num2.length(); i < n; i++)
            second[i] = Character.getNumericValue(num2.charAt(i));

        int result = 0;
        for (int i : first) {
            int currResult = 0;
            for (int j : second) {
                currResult = currResult * 10 + i * j;
            }
            result = result * 10 + currResult;
        }

        return Integer.toString(result);
    }

    public static void main(String[] args) {
        Multiply m = new Multiply();
        System.out.println(m.multiply("11133", "111"));
        System.out.println(m.multiply("111", "0"));
        
    }
}