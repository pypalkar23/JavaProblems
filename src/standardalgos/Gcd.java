package standardalgos;
class Gcd{
    public static void main(String[] args) {
        System.out.println(gcd(6,4)); 
    }

    public static int gcd(int a, int b){
        if (b==0)
            return a;
        if(a<b)
            return gcd(a,b%a);
        return gcd(b,a%b);
    }
}

/*10,6
6,10%6-> 6,4
4,6%4 -> 4,2
2,4%2-> 2,0
2,0 -> 2
*/
