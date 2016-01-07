
public class c2p3 {
   
    public static boolean removeMiddleNode(Node n) {
        if(n == null || n.next == null)
	    return false;
    	Node temp = n.next;
	n.data = temp.data;
	n.next = temp.next;
	return true;
    }

}
