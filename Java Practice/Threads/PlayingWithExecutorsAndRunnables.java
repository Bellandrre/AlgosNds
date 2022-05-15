package Threads;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlayingWithExecutorsAndRunnables {

    public static void main(String[] args) {

        // Invoking threads using Runnable Interface
        Runnable task = () -> System.out.println("I am thread " + Thread.currentThread().getName());
        // Invoking Threads like this is always expensive due to context switching happening at OS level.
        // To get rid of such a situation we use the ExecutorService interface which creates a pool of threads
        // and is handled by the JVM.

        ExecutorService service = Executors.newSingleThreadExecutor();

        for(int i = 0; i < 10; i++){
            new Thread(task).start();
        }

        // In this example we can see that the task was executed using a single thread instead of multiple.
        for(int i = 0; i < 10; i++){
            service.execute(task);
        }
        // I need to shut down the service as the interface creates non-deamon threads which keeps the JVM alive.
        service.shutdown();


    }
}
