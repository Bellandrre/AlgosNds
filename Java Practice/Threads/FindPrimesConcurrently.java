package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class FindPrimesConcurrently {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(4);
        ExecutorService service = Executors.newFixedThreadPool(4);

        List<Integer> list_1 = new ArrayList<>();
        Random random = new Random();


        List<Integer> list_2 = new ArrayList<>();
        while(list_2.size() != 100){
            list_2.add(random.nextInt(100 - 1 + 1) + 1); // Random between is (Max - Min + 1)
         }

        List<Integer> list_3 = new ArrayList<>();
        while(list_3.size() != 100){
            list_3.add(random.nextInt(200 - 102 ) + 101 );
        }

        List<Integer> list_4 = new ArrayList<>();
        while(list_4.size() != 100){
            list_4.add(random.nextInt(300 - 202) + 201);
        }

        while(list_1.size() != 100){
            list_1.add(random.nextInt(400 - 302) + 301);
        }

        FindPrimesWorker worker_1 = new FindPrimesWorker(barrier, list_1);
        FindPrimesWorker worker_2 = new FindPrimesWorker(barrier, list_2);
        FindPrimesWorker worker_3 = new FindPrimesWorker(barrier, list_3);
        FindPrimesWorker worker_4 = new FindPrimesWorker(barrier, list_4);

        List<Integer> finalResult = new ArrayList<>();
        Future<List<Integer>> future_1 = service.submit(worker_1);
        Future<List<Integer>> future_2 = service.submit(worker_2);
        Future<List<Integer>> future_3 = service.submit(worker_3);
        Future<List<Integer>> future_4 = service.submit(worker_4);

        finalResult.addAll(future_1.get());
        finalResult.addAll(future_2.get());
        finalResult.addAll(future_3.get());
        finalResult.addAll(future_4.get());

        for(Integer primeNums : finalResult){
            System.out.print(primeNums + " ");
        }

        System.out.println(worker_1.isPrime(25));

        service.shutdown();
    }
}
