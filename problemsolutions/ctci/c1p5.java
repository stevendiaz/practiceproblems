public class c1p5 {
	public static String replaceSpace(String input) {
		//Potential rework without appending function?
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == ' ') {
				result.append("%20");
			}
			else {
				result.append(input.charAt(i));
			}
		}
		return result.toString();
	}

}
