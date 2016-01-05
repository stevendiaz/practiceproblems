package ctci;

public class c1p6v2016 {

	public static void main(String[] args) {
		System.out.println(compressString("aaaabbccc"));
	}
	
	public static String compressString(String input) {
		StringBuilder result = new StringBuilder();
		int j = 0;
		int i = 0;
		while(i < input.length()) {
			char current = input.charAt(i);
			while(j < input.length() && current == input.charAt(j)) {
				j++;
			}
			result.append(input.charAt(i) + ("" + (j - i)));
			if(i == j)
				i++;
			else
				i = j;
		}
		if(result.toString.length() >= input)
			return input;
		else		
			return result.toString();
	}
}
