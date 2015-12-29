package ctci;

public class c1p7 {

	public static void main(String[] args) {
		int[][] multi = new int[][]{
				  { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				  { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				  { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
				  { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				  { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
				};
		print2DArray(multi);
		multi = setZeros(multi);
		print2DArray(multi);

	}
	
	private static void print2DArray(int[][] multi) {
		for(int i = 0; i< multi.length; i++)
		{
		    for(int j = 0; j< multi[0].length; j++)
		    {
		        System.out.print(multi[i][j]);
		    }
		    System.out.println();
		}
	}
	
	private static int[][] setZeros(int[][] arr) {		
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
	}

}
