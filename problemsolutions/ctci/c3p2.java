package ctci;


public class c2p3 {
	
	public class StackNode {
		int value;
		int minSubstack;
	}
	
	public Stack<StackNode> internalStack;

	public MinStack() {
		internalStack = new Stack<StackNode>();		
	}

	public void push(int value) {
		StackNode val = new StackNode();
		val.value = value;
		if(internalStack.size() == 0) {
			val.minSubstack = val.value;
			internalStack.push(val);
		} else {
			StackNode top = internalStack.peek();
			if(value < top.minSubstack)
				val.minSubstack = value;
			else
				val.minSubstack = top.minSubstack;
			internalStack.push(val);
		}
	}

	public int pop() {
		int result = internalStack.pop().value;
		return result;
	}

	public int min() {
		return internalStack.peek().minSubstack;
	}

}
