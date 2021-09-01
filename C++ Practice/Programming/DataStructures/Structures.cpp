/**
 * This is a simple program to show struct in C++ compared to enums in java
 */
#include <iostream>
using namespace std;
struct Rectangle{ // Defining a rectangle
    int length;
    int breadth;
};
struct Student{
    int rollNo;
    char name[250];
    char dept[250];
    char address[250];
};
int main(){
    struct Rectangle r; // declaration
    r.length = 10;
    r.breadth = 20;
    struct Rectangle r1 = {30, 60}; //declaration and initialization
    cout << "Area of rectangle "<< r.length*r.breadth << endl;
}
