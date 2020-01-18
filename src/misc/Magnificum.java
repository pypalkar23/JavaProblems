class Magnificum {
    public static void main(String args[]) {
        System.out.println(calculateWays(7));
    }
    
    public static int calculateWays(int blocks) {
        if (blocks <= 2)
            return 0;
        if (blocks >= 3 && blocks <= 4)
            return 1;
        int compute[]= new int[blocks+1];
        compute[0]=0;
        compute[1]=0;
        compute[2]=0;
        compute[3]=1;
        compute[4]=1;
        for(int i=5;i<=blocks;i++){
            
        }
        
    }


     
    public void helper(int result, int start, int target, int[] candidates){
        if(target==0){
            result++;
            return;
        }
        if(target<0){
            return;
        }
     
        for(int i=start; i<candidates.length; i++){ // each time start from different element
                helper(result, i+1, target-candidates[i], candidates); // and use next element only
        }
    }
}