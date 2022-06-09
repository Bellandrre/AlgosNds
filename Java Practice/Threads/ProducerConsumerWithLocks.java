package Threads;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class ProducerConsumerWithLocks {

    public static boolean isEmpty(List buffer){
        return buffer.size() == 0;
    }

    public static boolean isFull(List buffer){
        return buffer.size() == 50;
    }

    public static void main(String[] args) throws Exception{
        List<Integer> buffer = new ArrayList<>(50);

        Lock lock = new ReentrantLock();
        Condition isEmpty = lock.newCondition();
        Condition isFull = lock.newCondition();

        class Consumer implements Callable<String> {
            public String call() throws InterruptedException, TimeoutException{
                int count = 0;
                    while (count++ < 50) {
                        try {
                            lock.lock();
                            while (isEmpty(buffer)) {
                                // wait
                                if(!isEmpty.await(10, TimeUnit.MILLISECONDS)){
                                    throw new TimeoutException("Producer didn't produce anything");
                                } // If after 10ms if nothing happens on the Producer side, we should break.
                            }
                            buffer.remove(buffer.size() - 1);
                            isFull.signalAll();
                        }finally{
                            lock.unlock();
                        }
                    }
                    return "Consumed " + (count - 1);
                }
        }

        class Producer implements Callable<String>{
            public String call() throws Exception{
                int count = 0;
                while(count++ < 50){
                    try{
                        lock.lock();
                        //int i = 10/0; if this happened then Consumer won't get anything
                        while(isFull(buffer)){
                            isFull.await();
                        }
                        buffer.add(1);
                        isEmpty.signalAll();
                    }finally {
                        lock.unlock();
                    }
                }
                return "Produced " + (count - 1);
            }
        }

        List<Producer> producers = new ArrayList<>();
        List<Consumer> consumers = new ArrayList<>();

        for(int i = 0 ; i < 4; i++){
            producers.add(new Producer());
        }

        for(int j = 0; j < 4; j++){
            consumers.add(new Consumer());
        }

        ExecutorService service = Executors.newFixedThreadPool(8);
        System.out.println("Running");
        List<Callable<String>> producersAndConsumers = new ArrayList<>();
        producersAndConsumers.addAll(producers);
        producersAndConsumers.addAll(consumers);

        try{
            List<Future<String>> futures = service.invokeAll(producersAndConsumers);

            futures.forEach(future->{
                try{
                    System.out.println(future.get());
                }catch(InterruptedException | ExecutionException ex){
                    ex.printStackTrace();
                }
            });
        }finally{
            service.shutdown();
            System.out.println("Executor service has shut down");
        }

    }

}
