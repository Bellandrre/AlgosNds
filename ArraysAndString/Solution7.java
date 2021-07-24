package ArraysAndString;

public class Solution7 {
	public static void main(String[] args) {
		int matrix[][] = {{1,2,3,4,5},
						  {6,7,8,9,10},
						  {11,12,13,14,15},
						  {16,17,18,19,20},
						  {21,22,23,24,25}
						 };
		rotateMatrix(matrix);
	}
	
	static int[][] rotateMatrix(int matrix[][]){
		if(matrix.length == 0 || matrix.length !=matrix[0].length) return matrix;
		for(int layer=0;layer<matrix.length/2;layer++) {
			int first = layer; int last = matrix.length - 1 - layer;
			for(int i=first;i<last;i++) {
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("");
		}
		
		return matrix;
	}

}
