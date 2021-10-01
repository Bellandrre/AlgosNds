package LeetcodeProblems;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int closestSum = 0;
        Arrays.sort(nums);
        for(int i = 0 ; i <= nums.length -3; i++){
            if(i == 0 || nums[i] > nums[i-1]){
                int start = i + 1;
                int end = nums.length - 1;
                while(start < end){
                    int currSum = nums[i] + nums[start] + nums[end];
                    int diff = Math.abs(currSum - target);
                    if(currSum == target) return target;
                    if(diff < minDiff){
                        minDiff = diff;
                        closestSum = currSum;
                    }
                    if(currSum < target){
                        int currStart = start;
                        while(nums[currStart] == nums[start] && start < end){
                            start++;
                        }
                    }else{
                        int currEnd = end;
                        while(nums[currEnd] == nums[end] && start < end){
                            end--;
                        }
                    }
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int inputNums[] = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(inputNums, target));
    }

}
