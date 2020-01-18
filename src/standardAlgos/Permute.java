package standardalgos;
class Permute {
    public static void main(String[] args) {
        Permute p=new Permute();
        p.permute("ABCDE", 0, "ABCDE".length()-1);
    }

    public void permute(String str,int l,int r) {
        if(l==r){
            System.out.println(str);
        }
        for(int i=l;i<=r;i++)
        {
            str=swap(str,l,i);
            permute(str, l+1, r);
            str=swap(str,l,i);
        }
    }

    public String swap(String str, int a, int b) {
        char[] charArray = str.toCharArray();
        char temp = charArray[a];
        charArray[a] = charArray[b];
        charArray[b] = temp;
        return String.valueOf(charArray);
    }
}