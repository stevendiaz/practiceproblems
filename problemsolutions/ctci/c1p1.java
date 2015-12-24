public class c1p1 {
	public static void main(String[] args) {
		//Implement an algorithm to determine if a string has all unique characters.
		String input = "abcdefghijklmnopqrstuvwxyz";
		boolean test = hasUnique(input);
		System.out.println("Input: " +input+ " Result: " +test);
	}
	
	private static boolean hasUnique(String input) {
		int[] count = new int[256];
		for(int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);
			if(count[(int)current] > 0)
				return false;
			else 
				count[(int)current]++;
		}
		return true;
	}
}
