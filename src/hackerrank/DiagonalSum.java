package hackerrank;

import java.util.Scanner;

class DiagonalSum{
public static void main(String[] args) {
    Scanner scr=new Scanner(System.in);
    int n=Integer.parseInt(scr.nextLine());
    //int mat[][]=new int[n][n];
    int primaryDiagonal=0;
    int secondaryDiagonal=0;
    int lineCount=0;
    while(scr.hasNextLine())
    {
        String line[]=scr.nextLine().split("\\s+");
        // for(String s:line)
        //     System.out.print(s);
        // System.out.println("");
        primaryDiagonal+=Integer.parseInt(line[lineCount]);
        secondaryDiagonal+=Integer.parseInt(line[n-lineCount-1]);
        lineCount++;
    }

    System.out.println(Math.abs(primaryDiagonal-secondaryDiagonal));
    
}

}