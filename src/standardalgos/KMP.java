package standardalgos;
class KMP {
    public static void main(String[] args) {
        KMPFind("ABAAAAAA", "ABABC");
    }

    public static void KMPFind(String text, String pattern) {
        int patternLength = pattern.length();
        int textLength = text.length();
        int i = 0;
        int j = 0;
         // Preprocess the pattern (calculate lps[] array)
        int lps[] = lps(pattern);
        for (int a:lps)
            System.out.print(a);
        System.out.println("");
        while (i < textLength) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            
            if (j == patternLength) {
                System.out.println("pattern found at" + (i - j));
                j = lps[j - 1];
                // mismatch after j matches
            } else if (i < textLength && text.charAt(i) != pattern.charAt(j)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                {
                    i++;
                }
            }
        }
    }

    public static int[] lps(String pattern) {
        int patternLength = pattern.length();
        int len = 0;
        int i = 1;
        int[] lps = new int[patternLength];
        lps[0] = 0;

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;

            } else {// (pat[i] != pat[len])
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar 
                // to search step
                if (len != 0) {
                    len = lps[len - 1];
                     // Also, note that we do not increment
                     // i here
                } else {// if (len == 0)
                    lps[i] = 0;
                    i++; 
                }
            }
        }

        return lps;
    }
}