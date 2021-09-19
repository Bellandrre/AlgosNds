//
// Created by Karthik Kolathumani on 9/18/21.
//

#include<iostream>
using namespace std;

string minimumWindowSubstring(string inputString, string pattern){
    int givenString[256];
    int patternString[256];

    // if the pattern itself is longer than the given string
    if(pattern.size() > inputString.size()) return "";
    // initialize pattern string array with occurrences
    for(int i = 0; i < pattern.size(); i++)
        patternString[pattern[i]]++;

    int start = 0, max_len = INT_MAX, start_index = -1, count = 0;

    // Check the inputString for the pattern
    for(int i=0; i < inputString.size(); i++){
        givenString[inputString[i]]++;

        // If we see a character that MATCHES then we increment count
        if(givenString[inputString[i]] <= patternString[inputString[i]])
            count++;
        // if we see that the current window contains all the pattern characters if try to decrease the window if possible
        if(pattern.size() == count){
            // If the frequency of the current character is greater than the required frequency then we can try to decrease the window
            while(givenString[inputString[start]] > patternString[inputString[start]]
                   || patternString[inputString[start]] == 0){
                if(givenString[inputString[start]] > patternString[inputString[start]])
                    givenString[inputString[start]]--;
                
                start++;
            }
            int current_window_len = i - start + 1;
            if(max_len > current_window_len){
                max_len = current_window_len;
                start_index = start;
            }
        }
    }
    if(start_index == -1) return "";
    cout << max_len <<endl << start_index << start << endl;
    return inputString.substr(start_index, start_index + max_len);
}

int main(){
    string inputString = "ADOBECODEBANC";
    string pattern = "ABC";
    cout << minimumWindowSubstring(inputString, pattern) << endl;
}
