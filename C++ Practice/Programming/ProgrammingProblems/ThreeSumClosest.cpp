/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 */
#include<iostream>
#include<vector>
using namespace std;
    int threeSumClosest(vector<int> &nums, int target){
        vector<vector<int>> resultSet;
        int minClosest = INT_MAX;
        int closestSum = 0;
        if(nums.size() > 2){
            sort(nums.begin(), nums.end());
            for(int i = 0 ; i <= nums.size() - 3 ; i++) {
                if (i == 0 || nums[i] > nums[i - 1]) {
                    int start = i + 1;
                    int end = nums.size() - 1;
                    while (start < end) {
                        int currSum = nums[i] + nums[start] + nums[end];
                        if(currSum == target) return currSum;
                        int diff = abs(currSum - target);
                        if (diff < minClosest) {
                            minClosest = diff;
                            closestSum = currSum;
                        }
                        if (currSum < target) {
                            int currStart = start;
                            while (nums[currStart] == nums[start] && start < end) {
                                start++;
                            }
                        } else {
                            int currEnd = end;
                            while (nums[end] == nums[currEnd] && start < end) {
                                end--;
                            }
                        }
                    }
                }
            }
        }
        return closestSum;
    }
int main(){
        vector<int> inputNum = {-1,2,1,-4};
        int result = threeSumClosest(inputNum, 1);
        cout<< result << endl;
        return result;
}


