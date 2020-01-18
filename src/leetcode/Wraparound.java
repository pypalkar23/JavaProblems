class Wraparound {
    public static void main(String[] args) {
        Wraparound w = new Wraparound();
        System.out.println(w.findSubstringInWraproundString("zab"));
    }

    public int findSubstringInWraproundString(String p) {
        int ans = 0;
        int n = p.length();
        int tempArr[] = new int[26];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int curr = (p.charAt(i) - 'a') % 26;
            if (i > 0 && ((p.charAt(i - 1) - 'a' + 1) % 26) != curr)
                len = 0;
            if (++len > tempArr[curr]) {
                ans += len - tempArr[curr];
                tempArr[curr] = len;
            }
        }
        return ans;
    }
}