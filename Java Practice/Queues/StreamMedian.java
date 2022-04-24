package Queues;

import java.util.PriorityQueue;
import java.util.Comparator;

public class StreamMedian {

    double median;
    PriorityQueue<Double> minQueue = new PriorityQueue<>();
    PriorityQueue<Double> maxQueue = new PriorityQueue<>(new Comparator<Double>(){
        public int compare(Double a, Double b){
            return (int)(b - a);
        }
    });

    public void insert(int number){
        insertHelper(number);
    }

    private void insertHelper(int number){
        int sizeDiff = Math.abs(getSizeMaxQueue() - getSizeMinQueue());
        reBalance();
        minQueue.add((double)number);
    }

    public void reBalance(){
        int sumSize = getSizeMaxQueue() + getSizeMinQueue();
        if(sumSize % 2 != 0){
            maxQueue.add(minQueue.poll());
        }
    }

    private int getSizeMinQueue(){
        return minQueue.size();
    }

    private int getSizeMaxQueue(){
        return maxQueue.size();
    }

    public double getMedian(){
        return getMedianHelper();
    }

    private double getMedianHelper(){
        if(minQueue.isEmpty()) return maxQueue.peek();
        if(maxQueue.isEmpty()) return minQueue.peek();

        int sizeSum = getSizeMaxQueue() + getSizeMinQueue();

        if(sizeSum > 1 && sizeSum % 2 == 0){
            double median = (minQueue.peek() + maxQueue.peek()) / 2;
            return median;

        }else{
            return minQueue.peek() > maxQueue.peek() ? minQueue.peek() : maxQueue.peek();
        }
    }

    public static void main(String[] args) {
        StreamMedian sm = new StreamMedian();

        sm.insert(5);
        sm.insert(10);
        sm.insert(100);
        sm.insert(200);
        sm.insert(6);
        System.out.println(sm.getMedian());
    }

}
