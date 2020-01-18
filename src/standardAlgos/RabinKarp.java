
class RabinKarp {
    static int d = 256;

    public static void getPatternIndex(String text, String pattern, int q) {
        int M = pattern.length();
        int N = text.length();
        int h = 1;
        int p = 0; //hash value for pattern
        int t = 0; //hash value for txt

        //h would be pow(d,M-1)%q
        for (int i = 0; i < M - 1; i++)
            h = (h * d) % q;

        //calculate hash value for first window of text
        for (int i = 0; i < M; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        for (int i = 0; i <= N - M; i++) {
            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if (p == t) {
                int j = 0;
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }

                if (j == M)
                    System.out.println("Pattern Found at index " + i);
            }

            if (i < N - M) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i+M)) % q;
                //we might get negative value of t, converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }

    }

    public static void main(String args[]){
        String text="ABABCA";
        String pattern="BC";
        int q=101;
        getPatternIndex(text, pattern, q);

    }
}