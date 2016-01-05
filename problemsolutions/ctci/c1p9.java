package ctci;

public class c1p9 {

	public static void main(String[] args) {
		System.out.println("test".substring(0, 1));
	}
	
	public static boolean isRotation(String s1, String s2) {
		boolean result = false;
		int i = 1;
		String s2Substring = "";
		while(i < s1.length() - 1) {
			if(isSubstring(s2.substring(0, i), s1))
				s2Substring = s2.substring(0, i);
			else
				break;
			i++;
		}
		String remadeString = s2.substring(i, s2.length()) + s2Substring;
		if(remadeString == s1)
			result = true;
		
		return result;
	}
	
	public static boolean isSubstring(String s1, String s2) {
		//assume we have this for the problem, as specified by the book
		return false;
	}
}
