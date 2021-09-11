package StacksAndQueues;
import java.util.*;
public class Solution1 {
	int numberOfStacks = 3;
	int stackCapacity;
	int [] values;
	int [] sizes;
	
	public Solution1(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize*numberOfStacks];
		sizes = new int[numberOfStacks];
	}
	
	public void push(int stackNumber,int value) {
	/* Check if the StackNumer is full or not*/
		if(isFull(stackNumber)) throw new FullStackException();
		sizes[stackNumber]++;
		values[getTop(stackNumber)] = value;
	}
	
	
	public int peek(int stackNumber) {
		int top = getTop(stackNumber);
		return values[top];
		
	}
	
	public int pop(int stackNumber) {
		if(isEmpty(stackNumber)) {
			throw new EmptyStackException();
		}
		
		int topIndex = getTop(stackNumber);
		int value = values[topIndex];
		values[topIndex] = 0;
		sizes[stackNumber]--;
		return value;
		
	}
			
	public boolean isEmpty(int stackNumber) {
		return sizes[stackNumber] == 0;
	}
	
	
	public boolean isFull(int stackNumber) {
		return sizes[stackNumber] == stackCapacity;
	}
	
	public int getTop(int stackNumber) {
		int offset = stackNumber * stackCapacity; //3
		int size = sizes[stackNumber]; //1
		int top = offset + size -1; // 
		System.out.println("The value of top :"+top);
		return top;
	}
	
	public static void main(String[] args) {
		Solution1 s = new Solution1(3);
		s.push(1, 10);
		
		System.out.println(s.peek(1));
	}
	
}
