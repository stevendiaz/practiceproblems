package ctci;


//describe how you would implement three stacks with a single array

public class MultiStack {
	public int numStacks = 3;
	public int[] storage;
	public int capacity;
	private int stack1Index;
	private int stack2Index;
	private int stack3Index;	


	public MultiStack(int cap) {
		//size of the array will be capacity * 3;
		capacity = cap;
		storage = new int[capacity * numStacks];
		stack1Index = 0;
		stack2Index = capacity;
		stack3Index = capacity * 2;
	}

	public void push(int stackNum, int val) {
		if(stackNum == 1) {
			storage[stack1Index] = val;
			stack1Index++;
		} else if(stackNum == 2) {
			storage[stack2Index] = val;
			stack2Index++;
		} else if(stackNum == 3) {
			storage[stack3Index] = val;
			stack3Index++;
		}	
	}
	
	public int pop(int stackNum) {
		int result;
		if(stackNum == 1) {
			int result = storage[stack1Index];
			stack1Index--;
		} else if(stackNum == 2) {
			int result = storage[stack2Index];
			stack2Index--;
		} else if(stackNum == 3) {
			int result = storage[stack3Index];
			stack3Index--;
		}
	}

	public int peek(int stackNum) {
		if(stackNum == 1)
			return storage[stack1Index];
		else if(stackNum == 2)
			return storage[stack2Index];
		else if(stackNum == 3)
			return storage[stack3Index];
	}
}
