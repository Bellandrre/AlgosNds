//
// Created by Karthik Kolathumani on 9/12/21.
//

#include<iostream>
#include <unordered_map>
#include<vector>
using namespace std;

vector<vector<string>> groupAnagrams(vector<string>& str){
    unordered_map<string, vector<string>> mymap;
    vector<vector<string>> resultList;
    for(int i = 0 ; i < str.size() ; i++){
        string currString = str[i];
        sort(currString.begin() , currString.end());
        if(mymap.find(currString) != mymap.end()){
            mymap[currString].push_back(str[i]);
        }else{
            vector<string> temp = {str[i]};
            mymap[currString] = temp;
        }
    }

    for (const auto &it : mymap){
        resultList.push_back(it.second);
    }
    return resultList;
}

int main(){
    vector<string> inputStr = {"eat","tea","tan","ate","nat","bat"};
    groupAnagrams(inputStr);
}
