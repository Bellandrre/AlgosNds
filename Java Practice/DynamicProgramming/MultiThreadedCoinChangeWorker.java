package DynamicProgramming;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MultiThreadedCoinChangeWorker implements Runnable{

    private CyclicBarrier barrier;
    private int startAmount;

    private int endAmount;
    private volatile int[] dp;
    private int[] coins;
    private int amount;

    public MultiThreadedCoinChangeWorker(CyclicBarrier barrier, int startAmount, int[] dp, int[] coins, int amount, int endAmount){
        this.barrier = barrier;
        this.startAmount = startAmount;
        this.dp = dp;
        this.coins = coins;
        this.amount = amount;
        this.endAmount = endAmount;
    }

    public void run(){
        try {
            for (int currAmount = this.startAmount; currAmount <= this.amount; currAmount++) {
                for (int coin = 0; coin < coins.length; coin++) {
                    if (currAmount - coins[coin] >= 0) {
                        dp[currAmount] = Math.min(dp[currAmount], 1 + dp[currAmount - coins[coin]]);
                    }
                }
            }
            barrier.await();
        }catch(BrokenBarrierException | InterruptedException exception){
            exception.printStackTrace();
        }
    }

}
