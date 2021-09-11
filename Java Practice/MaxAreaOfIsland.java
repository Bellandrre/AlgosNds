

public class MaxAreaOfIsland {
	
	public static void main(String[] args) {
		int grid[][] = {{1,1,0,1,1},
				 {1,0,0,0,0},
				 {0,0,0,0,1},
				 {1,1,0,1,1}};
		
		MaxAreaOfIsland g = new MaxAreaOfIsland();
		System.out.println(g.calculateArea(grid));

	}

	private int calculateArea(int[][] grid) {
		int area = 0;
		int maxArea = 0;
		
		if(grid.length == 2 ) {
			if(grid[0][0] == 1) {area++;}
			if(grid[0][1] == 1) {area++;}
			if(grid[1][0] == 1) {area++;}
			if(grid[1][1] == 1) {area++;}
			if(maxArea < area) {
				maxArea = area;
			}
			
		}
		
		if(grid.length<2) {
			if(grid[0][0] == 1)  {area++;}
			if(maxArea < area) {
				maxArea = area;
			}
		}
		
		
		for(int i = 1; i < grid.length-1 ; i++) {
			for(int j = 1 ; j< grid[i].length-1 ; j++) {
				if(grid[i][j] == 1 ) {
					area++;}
					if(grid[i][j-1] == 1) {area++;}
					if(grid[i][j+1] == 1) {area++;}
					if(grid[i-1][j] == 1) {area++;}
					if(grid[i+1][j] == 1) {area++;}
					if(grid[i-1][j-1] == 1) {area++;}
					if(grid[i-1][j+1] == 1) {area++;}
					if(grid[i+1][j-1] == 1) {area++;}
					if(grid[i+1][j+1] == 1) {area++;}
				
				if(maxArea < area) {
					maxArea = area;
				}
				area = 0;
			}
		}
		return maxArea;
		
	}

}
