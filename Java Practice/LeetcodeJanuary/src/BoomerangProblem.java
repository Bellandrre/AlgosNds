import java.util.ArrayList;
public class BoomerangProblem {

        class Point{
            int x;
            int y;
            public Point(int x, int y){
                this.x = x;
                this.y = y;
            }
        }

        public int numberOfBoomerangs(int[][] points) {
            ArrayList<Point> pointList = new ArrayList<>();
            int result = 0;
            // Build the point objects
            for(int i = 0 ; i < points.length ; i++){
                Point pnt = new Point(points[i][0], points[i][1]);
                pointList.add(pnt);
            }

            for(int i = 0 ; i < pointList.size() ; i++){
                Point point_1 = pointList.get(i);
                for(int j = 0; j < pointList.size(); j++){
                    Point point_2 = pointList.get(j);
                    if(i != j){
                        double dist_1 = Math.sqrt( ((point_2.x - point_1.x) * (point_2.x - point_1.x)) +  ((point_2.y - point_1.y) * (point_2.y - point_1.y)) );

                        for(int k = 0; k < pointList.size(); k++){
                            if(k != j && k != i ){
                                Point point_3 = pointList.get(k);
                                double dist_2 = Math.sqrt( ((point_3.x - point_1.x) * (point_3.x - point_1.x)) +  ((point_3.y - point_1.y) * (point_3.y - point_1.y)) );
                                if(dist_2 == dist_1) result++;
                            }
                        }
                    }
                }
            }
            return result;
        }

    public static void main(String[] args) {
        int inputArray[][] = {{0,0}};
        BoomerangProblem boomerangObj = new BoomerangProblem();
        System.out.println(boomerangObj.numberOfBoomerangs(inputArray));
    }
}
