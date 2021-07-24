import java.awt.Point;
import java.util.*;
public class RobotPath {
	
	public static void main(String[] args) {
		boolean matrix[][] = {{true,true,true,true,true},
				{true,true,true,true,true},
				{true,true,true,true,true},
				{true,true,true,true,true},
				{true,true,true,true,true},
				{true,true,false,true,true},
				{true,true,true,true,true},
				{true,true,true,true,true},
				{true,true,true,true,true},
				{false,false,false,false,true}};
		ArrayList<Point> path = new ArrayList<>();
		//HashSet<Point> alreadyPresent = new HashSet<>();
		System.out.println(findPath(matrix,matrix.length-1,matrix[0].length-1/*,alreadyPresent*/,path));
		
	}
	
	public static boolean findPath(boolean[][] matrix, int row, int col, /*HashSet<Point> alreadyPresent,*/ArrayList<Point> path){
		if(row<0 || col<0|| !matrix[row][col]){
			return false;
		}
		boolean atOrigin = (row==0) && (col == 0);
		Point p = new Point(row,col);
		
		/*if(alreadyPresent.contains(p)) {
			return false;
		}*/
		
		if(atOrigin||findPath(matrix,row-1,col/*,alreadyPresent*/,path)||findPath(matrix,row,col-1/*,alreadyPresent*/,path)) {
			path.add(p);
			return true;
		}
		
		/*alreadyPresent.add(p);*/
		return false;
		
		
		
		
		
		
	}

}
