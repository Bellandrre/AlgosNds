package LeetcodeProblems;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class FourSum {

    public static List<List<Integer>> computeFourSum(int[] nums, int target){
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums); // This will amount for the significant amount of time complexity. O(nlogn)
        for(int i = 0 ; i <= nums.length - 4; i++) {
            if(i == 0 || nums[i] > nums[i-1]) {
                int startIndex = i + 1;
                int threeSumTarget =  target - nums[i];
                List<List<Integer>> threeSumResultList = computerThreeSum(nums, startIndex, threeSumTarget);
                for(List list : threeSumResultList){
                   int sum = list.stream().mapToInt(k -> (int) k).sum();
                   int currSum = sum + nums[i];
                   if(currSum == target){
                       list.add(0,nums[i]);
                       resultList.add(list);
                   }
                }
            }
        }
        return resultList;
    }

    private static List<List<Integer>> computerThreeSum(int nums[], int startIndex, int target){
        List<List<Integer>> resultList = new ArrayList<>();
        for(int i = startIndex; i <= nums.length - 3; i++){
            if(i == 1 || nums[i] > nums[i-1]){
               int start = i+1;
               int end = nums.length -1;

               while(start < end){
                   int currSum = nums[i] + nums[start] + nums[end];
                   if(currSum == target){
                       List<Integer> temp = new ArrayList<>();
                       temp.add(nums[i]);
                       temp.add(nums[start]);
                       temp.add(nums[end]);
                       resultList.add(temp);
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
        return resultList;
    }

    public static void main(String[] args) {
        int nums[] = {-2,-1,-1,1,1,2,2};
        int target = 0;
        List<List<Integer>> resultList = computeFourSum(nums, target);

        for(List l : resultList){
            for(int i = 0 ; i < l.size() ; i++){
                System.out.print(l.get(i) +" ");
            }
            System.out.println();
        }
    }
}
// {-2,-1,0,0,1,2}