package DataStructure;


//import java.io.*;
import java.util.*;
////Stack extends Vector class which provides 
//Object push(Object element)
//Object pop()
//Object peek()
//boolean isEmpty()
//Object search(Object element)


public class StackUsingVectors {

	public static void push(Stack<Integer> stack,int element ){
		stack.push(element);
	}
	
	public static void pop(Stack<Integer> stack){
		stack.pop();
	}
	
	public static void peek(Stack<Integer> stack){
		Integer k=(Integer)stack.peek();
		System.out.println(k);
	}
	
	public static void search(Stack<Integer> stack,int element){
		Integer pos = (Integer) stack.search(element);
		if(pos==-1)
			System.out.println("Element no present");
		else
			System.out.println("element at :" +pos);
	}
	
	
	
	
	public static void main(String[] args) {
		Stack<Integer> stack= new Stack<Integer>();
		
		for(int i=0;i<5;i++){
			push(stack,i);
		}
		
		stack.push(10);
		
		search(stack,3);
		peek(stack);
		pop(stack);
		peek(stack);
		
		
		
	}
	
}
