/*Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array*/
class SuperPow2 {
    public int superPow(int a, int[] b) {
        if (b == null || b.length == 0)
            return 1;
        long ans = 1;
        int multiplier = 1;
        int power = 0;
        for (int n = b.length - 1, i = n; i >= 0; i--) {
            power += multiplier * b[i];
            multiplier *= 10;
        }
        System.out.println(power);

        for (int i = 0; i < power; i++) {
            ans *= a % 1337;
            System.out.println(ans);
        }
        
        return (int) (ans % 1337);

    }

    public static void main(String[] args) {
        SuperPow2 s = new SuperPow2();
        System.out.println(s.superPow(2, new int[] { 3 }));
        System.out.println(s.superPow(4, new int[] { 5, 0, 0 }));
    }
}