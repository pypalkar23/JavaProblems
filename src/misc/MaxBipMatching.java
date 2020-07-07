package leetcode;
class MaxBipMatching {
    public int M = 6;
    public int N = 6;

    boolean bpm(boolean bpGraph[][], int u, boolean seen[], int matchR[]) {
        for (int v = 0; v < N; v++) {
            // If applicant u is interested in job v and v
            // is not visited
            if (bpGraph[u][v] && !seen[v]) {
                // If job 'v' is not assigned to an applicant OR
                // previously assigned applicant for job v (which
                // is matchR[v]) has an alternate job available.
                // Since v is marked as visited in the above line,
                // matchR[v] in the following recursive call will
                // not get job 'v' again
                seen[v] = true;
                if (matchR[v] < 0 || bpm(bpGraph, matchR[v], seen, matchR)) {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    int maxBPM(boolean bpGraph[][]) {
        int result = 0;
        // An array to keep track of the applicants assigned to
        // jobs. The value of matchR[i] is the applicant number
        // assigned to job i, the value -1 indicates nobody is
        // assigned.
        int matchR[] = new int[N];
        // Initially all jobs are available
        for (int i = 0; i < N; i++) {
            matchR[i] = -1;
        }

        for (int u = 0; u < M; u++) {
             // Mark all jobs as not seen for next applicant.
            boolean seen[] = new boolean[N];
            for (int i = 0; i < N; i++) {
                seen[i] = false;
            }
             // Find if the applicant 'u' can get a job
            if(bpm(bpGraph, u, seen, matchR))
                result++;
        }
        return result;
    }

    public static void main(String[] args) {
         boolean bpGraph[][] = new boolean[][]{
            {false, true, true, false, false, false},
            {true, false, false, true, false, false},
            {false, false, true, false, false, false},
            {false, false, true, true, false, false},
            {false, false, false, false, false, false},
            {false, false, false, false, false, true}
        };

        MaxBipMatching m=new MaxBipMatching();
        System.out.println(m.maxBPM(bpGraph));;
    }
}