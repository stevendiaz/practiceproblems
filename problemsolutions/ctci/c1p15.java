package ctci;

public class c1p15 {

	public static void main(String[] args) {
		System.out.println("pale, ple -> " +oneAway("pale","ple"));
		System.out.println("pales, pale -> " +oneAway("pales","pale"));
		System.out.println("pale, bale -> " +oneAway("pale", "bale"));
		System.out.println("pale, bake -> " +oneAway("pale", "bake"));

	}
	
	public static boolean oneAway(String original, String changed) {
		boolean result = false;
		int[] originalCount = new int[256];
		int[] changedCount = new int[256];
		//Count characters
		for(int i = 0; i < original.length(); i++)
			originalCount[(int)original.charAt(i)]++;
		for(int j = 0; j < changed.length(); j++)
			changedCount[(int)changed.charAt(j)]++;
		
		if((changed.length() >=  original.length() - 1) && (changed.length() <= original.length() + 1)){
			if(changed.length() == original.length()) {
				int numConflicts = 0;
				for(int i = 0; i < 256; i++){
					if(changedCount[i] != originalCount[i])
						numConflicts++;
				}
				if(numConflicts == 2)
					result = true;
			}
			else {
				int numConflicts = 0;
				for(int i = 0; i < 256; i++) {
					if(changedCount[i] != originalCount[i])
						numConflicts++;
				}
				if(numConflicts == 1)
					result = true;		
			}
		}		
		return result;
	}
}private static int[][] setZeros(int[][] arr) {		
		for(int r = 0; r < arr.length; r++) {
			for(int c = 0; c < arr[0].length; c++) {
				if(arr[r][c] == 0) {
					//loop through the entire column
					for(int i = 0; i < arr[0].length; i++)
						arr[r][i] = 0;
					for(int j = 0; j < arr.length; j++) 
						arr[j][c] = 0;
					return arr;
				}
			}
		}		
		return arr;
	
