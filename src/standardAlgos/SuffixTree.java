package justanotherpackage;
class IntWrapper {
    int wrappedInt;
}

class Node {
    Node children[] = new Node[256];
    Node suffixLink;
    int start;
    IntWrapper end;
    int suffixIndex;
}

class SuffixTree {
    Node lastNewNode = null;
    Node activeNode = null;
    String text = "";
    Node root = null;
    int activeEdge = -1;
    int activeLength = 0;
    int remainingSuffixCount = 0;
    IntWrapper leafEnd = new IntWrapper();
    IntWrapper rootEnd = null;
    IntWrapper splitEnd = null;
    //int size = -1;

    public Node newNode(int start, IntWrapper wrapper) {
        Node node = new Node();
        for (int i = 0; i < 256; i++)
            node.children[i] = null;
        node.suffixLink = root;
        node.start = start;
        node.end = wrapper;
        node.suffixIndex = -1;
        return node;
    }

    public boolean walkDown(Node currNode) {
        System.out.println("-----------------\nIn walkdown\nactiveLength "+activeLength+"\nedgeLength "+edgeLength(currNode));
        if (activeLength >= edgeLength(currNode)) {
            activeEdge += edgeLength(currNode);
            activeLength -= edgeLength(currNode);
            activeNode = currNode;
            System.out.println("Returns true\n-----------------");
            return true;
        }
        System.out.println("Returns false\n-----------------\n");
        return false;
    }

    public int edgeLength(Node n) {
        return (n.end.wrappedInt) - (n.start) + 1;
    }

    public void extendSuffixTree(int pos) {
        leafEnd.wrappedInt = pos;
        remainingSuffixCount++;
        System.out.println("remainingSuffixCount "+remainingSuffixCount);
        lastNewNode = null;

        while (remainingSuffixCount > 0) {
            if (activeLength == 0)
                activeEdge = pos;
                System.out.println("activeLength= "+activeLength);
                System.out.println("pos= "+pos);
            //if no node at the end
            if (activeNode.children[text.charAt(activeEdge)] == null) {
                System.out.println("-----New Node Block-----");
                activeNode.children[text.charAt(activeEdge)] = newNode(pos, leafEnd);
                System.out.println("activeEdge "+activeEdge+" "+"pos "+pos+" leafEnd "+leafEnd.wrappedInt);
                System.out.println("new node at "+ text.charAt(activeEdge));
                if (lastNewNode != null) {
                    lastNewNode.suffixLink = activeNode;
                    lastNewNode = null;
                }
            }
            else{
                //if there is character already at the position
                System.out.println("-----Char Already There-----");
                Node next=activeNode.children[text.charAt(activeEdge)];
                
                if(walkDown(next)){
                    continue;
                }
                System.out.println("currentNode "+next.start+" "+next.end.wrappedInt);
                if(text.charAt(next.start+activeLength)==text.charAt(pos)){
                    System.out.println("--------Char Equals Block------");
                    
                    if(lastNewNode != null && activeNode != root){
                        lastNewNode.suffixLink=activeNode;
                        lastNewNode=null;
                    }
                    activeLength++;
                    System.out.println("activeLength incremented "+activeLength);
                    System.out.println("-------------------");
                    break;
                }

                System.out.println("--------Char Not Equals Block----------");
                splitEnd = new IntWrapper();
                splitEnd.wrappedInt = next.start + activeLength - 1;
                
                Node split= newNode(next.start,splitEnd);
                System.out.println("Split Node start: "+next.start+" end "+splitEnd.wrappedInt);
                System.out.println("activeEdge "+activeEdge);
                activeNode.children[text.charAt(activeEdge)]=split;
                System.out.println("split node at "+ text.charAt(activeEdge));
                split.children[text.charAt(pos)] = newNode(pos,leafEnd);
                System.out.println("New Node pos "+pos+" leafEnd "+ leafEnd.wrappedInt);
                next.start += activeLength;
                System.out.println("next.start after addition "+ next.start);
                split.children[text.charAt(next.start)]=next;

                if(lastNewNode != null){
                    lastNewNode.suffixLink =split;
                }

                lastNewNode = split;
            }
            remainingSuffixCount--;
            System.out.println("remainingSuffixCount decremented "+ remainingSuffixCount);
            if(activeNode == root && activeLength > 0)
            {
                activeLength--;
                System.out.println("activeLength decremented "+ activeLength);
                activeEdge = pos - remainingSuffixCount + 1;
                
                System.out.println("activeEdge decremented "+pos+"-"+remainingSuffixCount+"+1 = "+ activeEdge);
            }
            else if(activeNode != root){
                activeNode =activeNode.suffixLink;
                System.out.println("through suffixLink activeNode is set to "+activeNode.start+" "+activeNode.end.wrappedInt);
            }
            System.out.println("-------------------");
        }

    }

    public void buildSuffixTree(){
        rootEnd=new IntWrapper();
        rootEnd.wrappedInt=-1;

        root=newNode(-1, rootEnd);

        activeNode = root;
        for(int i=0,size=text.length(); i<size;i++)
            extendSuffixTree(i);
    }

    public static void main(String[] args) {
        SuffixTree tree=new SuffixTree();
        tree.text="xabxac";
        tree.buildSuffixTree();
        // System.out.println(tree.root.children['x'].start+" "+tree.root.children['x'].end.wrappedInt);
        // System.out.println(tree.root.children[97].start+" "+tree.root.children[97].end.wrappedInt);
        // System.out.println(tree.root.children[97].children['b'].start+" "+tree.root.children[97].children['b'].end.wrappedInt);
        // System.out.println(tree.root.children[97].children['c'].start+" "+tree.root.children[97].children['c'].end.wrappedInt);
        //System.out.println(tree.root.children[67].start+" "+tree.root.children[67].end.wrappedInt);
        System.out.println(tree.root.children['x'].start+" "+tree.root.children['x'].end.wrappedInt);
        Node a=tree.root.children['x'];
        System.out.println(a.children['c'].start+" "+a.children['c'].end.wrappedInt);
        a=tree.root.children['a'];
        System.out.println(a.start+" "+a.end.wrappedInt);
        System.out.println(a.children['b'].start+" "+a.children['b'].end.wrappedInt);
        a=tree.root.children['b'];
        System.out.println(a.start+" "+a.end.wrappedInt);      
    }

}