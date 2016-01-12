package ctci;

public class c2p8 {
	public Node hasLoop(Node head) {
		Node fast = head;
		Node slow = head;
		while(fast.next != null & slow != null) {
			if(fast == slow)
				break;
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

}
