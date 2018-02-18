import java.util.Scanner;

class FizzBuzz{
    public static void main(String[] args) {
        Scanner scr=new Scanner(System.in);
        int T=scr.nextInt();
        for(int i=0;i<T;i++)
        {
            int N=scr.nextInt();
            for(int j=1;j<=N;j++){
                if(j%3==0 && j%5==0)
                    System.out.println("FizzBuzz");
                else if(j%3==0)
                    System.out.println("Fizz");
                else if(j%5==0)
                    System.out.println("Buzz");
                else
                    System.out.println(j);
            }
        }
    }
}