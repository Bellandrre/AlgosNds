package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FindPrimesConcurrently {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4);
        ExecutorService service = Executors.newFixedThreadPool(4);

        List<Integer> list_1 = new ArrayList<>();
        Random random = new Random();
        while(list_1.size() != 100){
            list_1.add(random.nextInt());
        }

        List<Integer> list_2 = new ArrayList<>();
        while(list_2.size() != 100){
            list_2.add(random.nextInt());
        }

        List<Integer> list_3 = new ArrayList<>();
        while(list_3.size() != 100){
            list_3.add(random.nextInt());
        }

        List<Integer> list_4 = new ArrayList<>();
        while(list_4.size() != 100){
            list_4.add(random.nextInt());
        }

        FindPrimesWorker worker_1 = new FindPrimesWorker(barrier, list_1);
        FindPrimesWorker worker_2 = new FindPrimesWorker(barrier, list_2);
        FindPrimesWorker worker_3 = new FindPrimesWorker(barrier, list_3);
        FindPrimesWorker worker_4 = new FindPrimesWorker(barrier, list_4);

        List<Integer> finalResult = new ArrayList<>();
        //finalResult.addAll(worker_1);
        //TODO: Call threads.
    }
}
