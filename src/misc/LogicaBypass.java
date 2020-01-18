package misc;
class LogicaBypass {
    public static void main(String args[]) {
        System.out.println(calculateChecksum(16005, 31808));
    }

    public static long calculateChecksum(long start, long length) {
        if (length == 1)
            return start;

        long result = 0;
        for (long i = length, n = 0; i > n; i--) {
            long tempXor = xorRange(start, start + i - 1);
            result ^= tempXor;
            start = start + length;
        }
        return result;
    }

    public static long xorRange(long a, long b) {
        if (a == b)
            return a;
        if (a == 0) {
            a = 1;
        }
        return xor(a - 1) ^ xor(b);
    }

    public static long xor(long a) {
        long res[] = { a, 1, a + 1, 0 };
        return res[(int) (a & 3)];
    }
}