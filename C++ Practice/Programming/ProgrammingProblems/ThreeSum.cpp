/**
 * 3 sum add upto a target 0
 * return all such sets of numbers
 * No duplicate sets
 * Will be using 3 pointer approach
 */
#include <iostream>
#include <vector>

using namespace std;
vector<vector<int>> computeThreeSum(int arr[], int arr_size){
    vector<vector<int>> resultSet;
    // Expected result - {[-1, -1, 2], [-1, 0, 1]}

    int size = arr_size;

    int target = 0;
    sort(arr,  arr + size);

    for(int i = 0 ; i < size - 3; i++){
        if(i == 0 || arr[i] > arr[i-1]){ // To make sure we are not considering duplicate elements
            int start = i+1;
            int end = size - 1;
            while(start <  end){
                int currSum = arr[i] + arr[start] + arr[end];
                if(currSum == target){
                    vector<int> currResultSet = {arr[i], arr[start], arr[end]};
                    resultSet.push_back(currResultSet);
                }
                if(currSum < 0){ // then move sum is too low move start pointer
                    int currStart = start;
                    while(arr[currStart] == arr[start] && start < end){
                        start++;
                    }
                }else{ // Sum is too big
                    int currEnd = end;
                    while(arr[currEnd] == arr[end] && start < end){
                        end--;
                    }
                }
            }
        }
    }
    return resultSet;
}


int main(){
    int arr[] = {-1, 0, 1, 2, -1, -4};

    vector<vector<int>> result = computeThreeSum(arr, sizeof(arr)/sizeof(arr[0]));
    for(int i=0; i < result.size() ; i++){
        for(int j= 0 ;j < result[i].size(); j++){
            cout<< result[i][j] << " ";
        }
        cout<< "\n";
    }
    return 0;
}

