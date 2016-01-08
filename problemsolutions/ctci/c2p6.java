package ctci;

public class c2p6 {
	
	public boolean isPalindromeLL(Node head) {
		if(temp == null)
			return false;
		Node temp = head;
		Stack<T> st = new Stack<T>();
		while(temp != null) {
			st.push(temp.data);
			temp = temp.next;
		}
		temp = head;
		while(temp != null) {
			if(temp.data != st.pop())
				return false;
		}
		return true;
	}

}
