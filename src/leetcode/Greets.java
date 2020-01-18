package leetcode;
class Greets{
    public static void main(String args[]){
        System.out.println(calculateGreets(""));
        System.out.println(calculateGreets(null));
        System.out.println(calculateGreets("--<-<>-->--<"));
        System.out.println(calculateGreets("----><----"));
        System.out.println(calculateGreets("--->-><-><-->-"));
        System.out.println(calculateGreets("<<>-<><<->--<>>->>-><--><<>>><>><->->>><--<<<->><>><<<"));
    }

    public static int calculateGreets(String corridor){
        if(corridor==null)
            return 0;
        if(corridor.length()==0)
            return 0;
        int result = 0;
        int outgoing =0 ;
        for(int i=0,n=corridor.length();i<n;i++){
            if(corridor.charAt(i)=='>'){
                //increase the counter of who are going to te right;
                outgoing++;
            }
            if(corridor.charAt(i)=='<'){
                //anyone who is moving to the left will greet everyone who is moving to the right
                result += 2*(outgoing);
            }
        }
        return result;
    }
}