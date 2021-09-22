package LeetcodeProblems;
import java.util.*;

public class MajorityElementVotingAlgo {

    public List<Integer> findMajaority(int[] nums){
        List<Integer> result = new ArrayList<>();

        if(nums.length == 0 || nums == null) return result;

        int candidate_1 = nums[0];
        int count_1 = 0;

        int candidate_2 = nums[0];
        int count_2 = 0;

        for(int i = 0 ; i < nums.length; i++){
            int curr = nums[i];

            if(curr == candidate_1) count_1++;
            else if(curr == candidate_2) count_2++;

            else if(count_1 == 0){
                candidate_1 = curr;
                count_1 = 1;
            }

            else if(count_2 == 0){
                candidate_2 = curr;
                count_2 = 1;
            }else{
                count_1--;
                count_2--;
            }
        }
        count_1 = 0;
        count_2 = 0;

        for(Integer i : nums){
            if(i == candidate_1) count_1++;
            else if(i == candidate_2) count_2++;
        }
        if(count_1 > nums.length/3) result.add(candidate_1);
        if(count_2 > nums.length/3) result.add(candidate_2);
        return result;
    }

}
