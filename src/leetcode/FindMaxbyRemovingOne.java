package leetcode;
class FindMaxByRemovingOne{
    public static void main(String[] args) {
        System.out.println(FindMaxByRemovingOne("1450"));
        System.out.println(FindMaxByRemovingOne("450"));
        System.out.println(FindMaxByRemovingOne("10000"));
    }

    public static int FindMaxByRemovingOne(String str){
        if(str.length()==1)
            return 0;
        int i=0;
        for(i=0;i<str.length()-1;i++){
            if(Character.getNumericValue(str.charAt(i))<Character.getNumericValue(str.charAt(i+1))){
                break;
            }
        }
        int min=Character.getNumericValue(str.charAt(i)),minIndex=i;
        for(int j=i-1;j>=0;j--){
            if(Character.getNumericValue(str.charAt(j))<min)
            {
                min=Character.getNumericValue(str.charAt(j));
                minIndex=j;
            }
            
        }
        
        return Integer.parseInt(str.substring(0,minIndex)+str.substring(minIndex+1));
    }
}