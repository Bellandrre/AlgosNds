package Threads;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheWithReadWriteLock {
    HashMap<Long, String> cacheWithoutConcurrency = new HashMap<>();
    static HashMap<Long, String> cacheWithConcurrency = new HashMap<>();

    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();


    public String put(Long key, String value){
        return cacheWithoutConcurrency.put(key, value);
    }

    public String get(Long key){
        return cacheWithoutConcurrency.get(key);
    }

    public String put_1(Long key, String value){
        writeLock.lock();
        try {
            return cacheWithConcurrency.put(key, value);
        }finally {
            writeLock.unlock();
        }
    }

    public String get_1(Long key){
        readLock.lock();
        try {
            return cacheWithConcurrency.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CacheWithReadWriteLock cache = new CacheWithReadWriteLock();

        // Calling the current
        class Producer implements Callable<String>{
            private Random random = new Random();
            public String call(){
                while(true){
                    long key = random.nextInt(1_000);
                    // This line below causes race condition when executed concurrently by different threads and hence fails to do an insert into the cache;
                    cache.put(key, Long.toString(key));
                    if(cache.get(key) == null){
                        System.out.println( "The key " + key + " was not inserted " + "I am thread - " + Thread.currentThread().getName());
                    }
                }
            }
        }

        class WriteIsolatedProducer implements Callable<String>{
            private Random rand = new Random();
            public String call(){
                while(cache.cacheWithConcurrency.size() != 1_000){
                    long key = rand.nextInt(1_000);
                    cache.put_1(key, Long.toString(key));
                    if(cache.get_1(key) == null){
                        System.out.println("The key " + key + " was not inserted " + "I am thread - " + Thread.currentThread().getName());
                    }
                }
                return "The size has exceeded";
            }
        }

        ExecutorService service = Executors.newFixedThreadPool(4);

        try{
            for(int i = 0 ; i < 4; i++){
                //service.submit(new Producer());
            }

            for (int i = 0; i < 4; i++){
                service.submit(new WriteIsolatedProducer());
            }
        }finally {
            service.shutdown();
        }
    }


}
