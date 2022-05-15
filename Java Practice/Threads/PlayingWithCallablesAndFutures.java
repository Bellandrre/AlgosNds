package Threads;
import java.util.concurrent.*;

public class PlayingWithCallablesAndFutures {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        // Instead of using Runnable interface to create a task, I am using Callable.
        // Callable is a generic interface which returns a value unlike Runnable.
        // For long-running tasks, submitted to a pool of threads via the ExecutorService, returns a Future object (which acts like a wrapper around the returned value from the Callable task)
        Callable<String> task = () -> {
          Thread.sleep(300);
          return "I am in thread " + Thread.currentThread().getName();
        };

        ExecutorService service = Executors.newFixedThreadPool(4);

        for(int i = 0; i < 10; i++){
            // Future object is like a callback. It is used for long-running tasks which doesn't return immediately
            Future<String> futureObj = service.submit(task);
            System.out.println("I get - "+ futureObj.get());
        }

        try {
            for (int j = 0; j < 10; j++) {
                Future<String> futureObj = service.submit(task);
                // This future obj specifies a timeout for our Callable task, hence will throw exception
                System.out.println("I get - " + futureObj.get(10, TimeUnit.MICROSECONDS));
            }
        }finally {
            service.shutdown();
        }
    }
}
