package Threads;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class FindPrimesWorker implements Callable<List<Integer>>{
    private CyclicBarrier barrier;
    private List<Integer> inputList;

    public FindPrimesWorker(CyclicBarrier barrier, List<Integer> inputList){
        this.barrier = barrier;
        this.inputList = inputList;
    }

    public List<Integer> call(){
        List<Integer> result = findPrimes(inputList);
        try{
            barrier.await();
        } catch(InterruptedException | BrokenBarrierException ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static List<Integer> findPrimes(List<Integer> inputList){
        List<Integer> result = new ArrayList<>();
        for(Integer number : inputList){
            if(isPrime(number)){
                result.add(number);
            }
        }
        return result;
    }

    public static boolean isPrime(Integer number){
        if(number <= 1) return false;
        if(number == 2) return true;
        if(number % 2 == 0) return false;

        for(int i = 3; i < Math.sqrt(number); i++){
            if(number % i == 0) return false;
        }
        return true;
    }

}
