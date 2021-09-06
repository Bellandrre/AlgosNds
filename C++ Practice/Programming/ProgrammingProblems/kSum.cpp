/**
 * Generalize 3 or 4 sum problem to to k sum
 * The below code uses a recursive approach to find k sum adding upto a target t
 */
#include<iostream>
#include<vector>
using namespace std;
  vector<vector<int>> computeTwoSum(int nums[], int left, int right, int target){
    vector<vector<int>> twoSumList;
    while( left < right ){
        int sum = nums[left] + nums[right];
        if( sum < target ){
            left++;
        }else if( sum > target ){
            right--;
        }else{
            vector<int> temp;
            temp.push_back(nums[left]);
            temp.push_back(nums[right]);
            twoSumList.push_back(temp);


            while(left < right && nums[left] == nums[left +1]){
                left++;
            }

            while(left < right && nums[right] == nums[right+1]){
                right++;
            }
            left++;
            right--;
        }
    }
    return twoSumList;
  }

  vector<vector<int>> KSum_recursive(int nums[], int numsSize, int index, int k, int target) {
        vector<vector<int>> kList;
        if(k == 2){
            kList = computeTwoSum(nums, index, numsSize, target);
            return kList;
        }

        kList.clear();

        for( int i = index; i < (numsSize) - k + 1; i++ ){
            vector<vector<int>> temp = KSum_recursive(nums, numsSize, index + 1, k -1 , target - nums[i] );

            if(temp.size() > 0 ) {
                for (int i = 0; i < temp.size(); i++) {
                    temp[i].push_back(nums[i]);
                }
            }
            kList.insert(kList.end(), temp.begin(), temp.end());

            while(i < numsSize - k + 1 && nums[i] == nums[i + 1]){
                i++;
            }
        }
      return kList;
    }

  int main(){
      return 0;
  }

