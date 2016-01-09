package ctci;

public class c2p7 {
	
	public Node findIntersection(Node head1, Node head2) {
		Node tail1 = sendToTail(head1);
		Node tail2 = sendToTail(head2);
		if(tail1 != tail2)
			return null;
		int size1 = sizeOf(head1);
		int size2 = sizeOf(head2);
		int diff = size1 - size2;
		Node temp1 = head1;
		Node temp2 = head2;
		if(diff < 0)
			temp2 = traverseList(temp2, diff);
		else if (diff > 0)
			temp1 = traverseList(temp1, diff);
		while(temp1 != temp2) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return temp1;
	}

	public Node traverseList(Node head, int incr) {
		Node temp = head;
		int p = 0;
		while(temp != null && p < incr) {
			p++;
			if(temp.next == null)
				break;
		} 
		return temp;
	}

	public Node sendToTail(Node head) {
		Node temp = head;
		while(temp != null) {
			if(temp.next == null)
				break;
			temp = temp.next;
		}
		return temp;
	}

	public int sizeOf(Node head) {
		int size = 0;
		Node temp = head;
		while(temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}


}
