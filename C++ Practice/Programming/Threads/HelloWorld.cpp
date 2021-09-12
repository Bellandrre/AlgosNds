//
// Created by Karthik Kolathumani on 9/12/21.
//

#include<stdio.h>
#include<iostream>
#include<pthread.h>
#include<errno.h>
using namespace std;
static void * thread_fn_callback(void *arg){
    char *input = (char *)arg;
    while(1){
        cout << "Input String = " << input;
        sleep(1);
    }
}

void thread1_create(){
    pthread_t pthread1;

    static char *thread_input1 = "This is thread 1";

    int rc = pthread_create(&pthread1,
                            NULL,
                            thread_fn_callback,
                            (void *)thread_input1);
    if(rc != 0){
        cout << "Error occurred, thread could not be created | error = " << rc;
        exit(0);
    }
}

int main(int argc, char **argv){
    thread1_create();
    cout << "The main thread is paused";
    pause();
    return 0;
}
