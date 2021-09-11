import java.util.*;
public class ArraysOfArrays {
	public static void main(String[] args) {
		String array[][] = {{"Karthik"},{"Hello","World"},{"1","2","3"}};
		StringBuilder buildString = new StringBuilder();
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				buildString.append(array[i][j]);
			}
			
		}
		System.out.println(buildString.toString());			
	}
}
