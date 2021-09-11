//
// Created by Karthik Kolathumani on 9/11/21.
//
#include<iostream>
#include<vector>
using namespace std;

vector<vector<int>> computeThreeSum(int nums[], int numsSize, int startIndex, int target){
    vector<vector<int>> resultList;
    for(int i = startIndex; i<= numsSize - 3; i++ ){
        if(i == 1 || nums[i] > nums[i-1]){
            int start = i +1;
            int end = numsSize-1;
            while(start < end){
                int currSum = nums[i] + nums[start] + nums[end];
                if(currSum == target){
                    vector<int> temp = {nums[i], nums[start], nums[end]};
                    resultList.push_back(temp);
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

vector<vector<int>> computeFourSum(int nums[], int numsSize, int target ){
    vector<vector<int>> resultList;
    sort(nums, nums + numsSize);
    for(int i = 0 ; i <= numsSize -4; i++){
        if(i == 0 || nums[i] > nums[i-1]){
            vector<vector<int>> threeSumResult = computeThreeSum(nums, numsSize , i+1, target - nums[i]);
            for(int k = 0 ; k < threeSumResult.size(); k++){
                int currentSum = 0;
                for(int j = 0 ; j < threeSumResult[k].size(); j++){
                    currentSum += threeSumResult[k][j];
                }
                int currFourSum = currentSum + nums[i];
                if(currFourSum == target){
                    threeSumResult[k].push_back(nums[i]);
                    resultList.push_back(threeSumResult[k]);
                }
            }
        }
    }
    return resultList;
}

int main(){
    int inputNums[] = {1,0,-1,0,-2,2};
    int target = 0;
    int numsSize = sizeof(inputNums)/sizeof(inputNums[0]);
    vector<vector<int>> resultList = computeFourSum(inputNums, numsSize, target);
    for(int k = 0 ; k < resultList.size(); k++){
        for(int j = 0 ; j < resultList[k].size(); j++){
            cout << resultList[k][j] << " ";
        }
        cout << endl;
    }
    return 0;
}

