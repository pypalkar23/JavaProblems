package standardalgos;
class NaiveSearchAlgo{
    public static void main(String[] args) {
        patternSearch("df jns", " ");
    }
    public static void patternSearch(String text,String pattern){
        int patternLength=pattern.length();
        for(int i=0,n=text.length();i<n;i++){
            int j=0;

            for(j=0;j<patternLength;j++){
                if(text.charAt(i+j)!=pattern.charAt(j))
                    break;
            }

            if(j==patternLength){
                System.out.println("pattern found at index:"+i);
            }
        }
    }
}