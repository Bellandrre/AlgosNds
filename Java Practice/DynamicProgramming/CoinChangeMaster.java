package DynamicProgramming;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CoinChangeMaster {


    public static void main(String[] args) throws Exception {

        int coins[] = {1,3,4,5};
        int amount = 7;
        int  dp[] = new int[8];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        CyclicBarrier barrier = new CyclicBarrier(2);
        ExecutorService service = Executors.newFixedThreadPool(2);

        MultiThreadedCoinChangeWorker worker_1 = new MultiThreadedCoinChangeWorker(barrier, 0, dp, coins, 7, 3);
        MultiThreadedCoinChangeWorker worker_2 = new MultiThreadedCoinChangeWorker(barrier, 4, dp, coins, 7, 7);


        service.submit(worker_1);
        service.submit(worker_2);

        System.out.println(dp[amount]);

        service.shutdown();
    }
}
