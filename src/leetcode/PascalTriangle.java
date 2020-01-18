package leetcode;
class PascalTriangle {
    public int calcDigitAtPos(int col, int row) {
        if (col == 0 || (col == row))
            return 1;
        else
            return calcDigitAtPos(col, row - 1) + calcDigitAtPos(col - 1, row - 1);

    }

    public static void main(String[] args) {
        PascalTriangle p = new PascalTriangle();
        for (int i = 0; i < 6; i++)
            {
            for (int j = 0; j <= i; j++) 
                System.out.print(p.calcDigitAtPos(j, i) + " ");
                System.out.println("");
            }

    }
}