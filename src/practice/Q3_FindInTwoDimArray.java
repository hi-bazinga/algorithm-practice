package practice;

public class Q3_FindInTwoDimArray {
	
	public static void main(String[] args) {
		int[][] matrix = {
			{1, 2, 3, 4},
			{2, 4, 6, 8},
			{3, 6, 9, 12}
		};
		
		boolean result = findNum(matrix, 9);
		System.out.println(result);
	}
	
	public static boolean findNum(int[][] matrix, int num) {
		int row = 0;
		int col = matrix[0].length - 1;
		
		while (row < matrix.length || col < 0) {
			int tmpNum = matrix[row][col];
			
			if (tmpNum == num)
				return true;
			else if ( matrix[row][col] < num )
				row ++;
			else
				col --;
		}
		
		return false;
	}
	
}
