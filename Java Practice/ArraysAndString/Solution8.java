package ArraysAndString;

import java.util.Arrays;

public class Solution8 {
	public static void main(String[] args) {
		int matrix[][] = {{1,2,3,4,5},
						  {0,7,0,9,10},
						  {11,12,13,14,15},
						  {16,17,18,19,20},
						  {21,22,23,24,25}
						 };
		nullifyMatrix(matrix);
	}
	
	public static int[][] nullifyMatrix(int[][]matrix){
		
		// This solution takes additional space of n. This can be avoided but this is much 
		//more understandable code.
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix.length];
		Arrays.fill(row, false);
		Arrays.fill(column, false);
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]==0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		
		
		for(int i=0;i<matrix.length;i++) {
			if(row[i]) nullifyRow(matrix,i);
		}
		
		for(int j=0;j<matrix.length;j++) {
			if(column[j]) nullifyColumn(matrix,j);
		}
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("");
		}
		
		return matrix;
		
	}
	
	static void nullifyRow(int[][]matrix,int row) {
		for(int i=0;i<matrix.length;i++) {
			matrix[row][i] = 0;
		}
	}
	
	static void nullifyColumn(int [][]matrix,int column) {
		for(int j=0;j<matrix.length;j++) {
			matrix[j][column] =0;
		}
	}
}
