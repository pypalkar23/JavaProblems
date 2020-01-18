package misc;
class IntWrapper {
   int a;
}
class Node{
    public IntWrapper wrapper;

    public Node(IntWrapper wrapper){
        this.wrapper=wrapper;
    }
}
public class checkCharIndex {
    public static void main(String[] args) {
        IntWrapper wrapper=new IntWrapper();
        wrapper.a=10;
        Node a=new Node(wrapper);
        System.out.println(a.wrapper.a);
        wrapper.a=15;
        System.out.println(a.wrapper.a);
       
    }

}