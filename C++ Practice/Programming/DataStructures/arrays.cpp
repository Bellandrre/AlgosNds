/**
* Array basic in c++
* Looping constructs like primitive for loops and for each, initialization etc.
*/
#include <iostream>
using namespace std;
int main(){
    int array[5]; // Declaration
    int array2[10] = {0}; // Declaration and initializing all elements with 0

    for(int i= 0 ; i < sizeof(array)/sizeof(array[0]); i++){ //  primitive for loop
        array[i] = (i+1)*10;
    }

    for(int x:array2){ // Java style for each loop
        printf("%d ",x);
    }

    cout << "\n";

    for(int i=0 ; i < sizeof(array)/sizeof(array[0]); i++){ // using cout and printf in c++
        cout << array[i] << " ";
        printf("\n");
    }
    return 0;
}