package ctci;

public class c2p2 {
    public Node getKthToLast(Node head, int k) {
    	//find size
    	Node temp = head;
    	int size = 0;
    	while(temp != null) {
    		size++;
    		temp = temp.next;
    	}
    	int index = size - (k - 1);
    	int i = 0;
    	temp = head;
    	while(i < index) {
    		temp = temp.next;
    	}
    	return temp;
    }
}
