package ctci;

public class c2p1 {
	public static void main(String args[]) {
		//TODO: Find implementation of singly linked list to test
	}
	
	public static void removeDuplicates(Node head) {
		Node n = head;
		Node n2 = n.next;
		while(n2 != null) {
			Node fwd = head;
			while(fwd != current) {
				if(fwd.data == n.data){
					Node temp = current.next;
					n.next = temp;
					n2 = temp;
					break;
				}
				fwd = fwd.next;
			}
			if(runner = current) {
				n = n2;
				n2 = n2.next;
			}
		}
	}
}
