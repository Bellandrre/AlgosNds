package Threads;
import java.util.concurrent.*;
import java.sql.ResultSet;
public class ExecutorPattern{

    public static void printAuthor(Future futureObj) throws Exception{
        ResultSet rs = (ResultSet) futureObj.get();
        System.out.print("Author Name - \n");
        while(rs.next()){
            System.out.println(rs.getString(2));
        }
        rs.close();
    }

    public static void printPost(Future futureObj) throws Exception{
        ResultSet rs = (ResultSet) futureObj.get();
        System.out.print("Posts Title - \n");
        while(rs.next()){
            System.out.println(rs.getString(3));
        }
        rs.close();
    }


    public static void main(String[] args) throws Exception{
        // Task 0 get the total count of authors
        Callable<Integer> task_0 = ()->{
          return new BellandraDBConnect().getCount(BellandraDBConnect.BellandraDBEntity.AUTHOR);
        };

        // Task 2 gets the total count of posts
        Callable<Integer> task_2 = ()->{
            return new BellandraDBConnect().getCount(BellandraDBConnect.BellandraDBEntity.POSTS);
        };


        ExecutorService service = Executors.newFixedThreadPool(10);
        try {
            Future<Integer> countAuthorFtrObj = service.submit(task_0);
            Future<Integer> countPostFtrObj = service.submit(task_2);

            Integer countAuthors = countAuthorFtrObj.get();
            Integer countPosts = countPostFtrObj.get();

            for(int i = 1; i <= countAuthors; i++) {
                final Integer id = i;
                printAuthor(service.submit(new Callable<ResultSet>() {
                    @Override
                    public ResultSet call() throws Exception {
                        //Thread.sleep(300);
                        System.out.println("This thread is in Authors - " + Thread.currentThread().getName());
                        return new BellandraDBConnect().getAuthors(id);
                    }
                }));
            }


            for(int j = 1; j <= countPosts; j++) {
                final Integer id = j;
                printPost(service.submit(new Callable<ResultSet>() {
                    @Override
                    public ResultSet call() throws Exception {
                        System.out.println("This thread is in Posts - " + Thread.currentThread().getName());
                        return new BellandraDBConnect().getPosts(id);
                    }
                }));
            }

        }finally{
            service.shutdown();
        }
    }
}
