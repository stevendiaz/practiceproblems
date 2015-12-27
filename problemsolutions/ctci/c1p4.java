

public class c1p4 {

	private static boolean isAnagram(String input1, String input2) {
		boolean result = true;
		int[] count1 = new int[256];
		int[] count2 = new int[256];
		for(int i = 0; i < input1.length(); i++) {
			count1[(int)input1.charAt(i)]++;
		}
		for(int j = 0; j < input2.length(); j++) {
			count2[(int)input2.charAt(j)]++;
		}
		for(int k = 0; k < 256; k++) {
			if(count2[k] != count1[k])
				return false;
		}
		return result;
	}

}
