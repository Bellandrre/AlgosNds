//
// Created by Karthik Kolathumani on 9/23/21.
//

#include<iostream>
using namespace std;
static int table[10000];
static int stack[10000];
static int head;

static void insert(int value){
    table[value] = ++head;
    stack[head] = value;
}

static bool search(int value){
    if(head <= -1) return false;
    else{
        int stackIndex = table[value];
        if(stack[stackIndex] != value) return false;
        else return true;
    }
}

/**
 * Lets consider elements entered are 1, 5, 6 , 7, 9
 * head 4
 * table[<>, 0, <> , <>, <>, 1, 2, 3, <>, 5]
 * stack[1, 5, 6, 7, 9]
 *
 * element to be deleted  - 5
 * it exists
 * stack[table[5]] is 5
 * stack[head] is 9
 * stack[table[5]] = stack[head]
 * stack[1, 9, 6, 7, 9]
 *
 * head = 4
 * stack[1, 9, 6, 7, 9]]
 * table[<>, 0, <> , <>, <>, 1, 2, 3, <>, 1]
 *
 * head 3
 * stack[1, 9, 6, 7, null]
 * table[<>, 0, <> , <>, <>, <>, 2, 3, <>, 1]
 *
 */
static void delete_1(int value){
    if(search(value) == true){
        stack[table[value]] = stack[head];
        table[stack[head]] = table[value];
        stack[head] = -2;
        table[value] = -2;
        head--;
    }
}

int main(){
    //1, 22, 6 , 7, 9
    insert(1);
    cout << search(1) << endl;
    cout << search(10) << endl;
    insert(22);
    cout << search(22) << endl;
    insert(6);
    insert(7);
    delete_1(22);
    insert(10);
    cout << search(22) << endl;
    cout << search(1) << endl;
    cout << search(10) << endl;
    return 0;
}

