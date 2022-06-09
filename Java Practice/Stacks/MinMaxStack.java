package Stacks;
import java.util.LinkedList;
import java.util.Stack;

public class MinMaxStack {

    class Element{
        int currentMax;
        int currentMin;
        int value;

        public Element(int value){
            this.value = value;
        }

        public Element(int value, int currentMax, int currentMin){
            this.value = value;
            this.currentMax = currentMax;
            this.currentMin = currentMin;
        }
    }

    Stack<Element> stack = new Stack<>();

    public int peek() {
        if(!stack.isEmpty()){
            return stack.peek().value;
        }else{
            return -1;
        }
    }

    public int pop() {
        if(!stack.isEmpty()){
            Element poppedItem = stack.pop();
            return poppedItem.value;
        }
        return -1;
    }

    public void push(Integer number) {

        Element newElement = new Element(number);

        if(!stack.isEmpty()){
            Element currentMinMax = stack.peek();

            newElement.currentMin = Math.min(currentMinMax.currentMin, number);
            newElement.currentMax = Math.max(currentMinMax.currentMax, number);

        }else{
            newElement.currentMax = number;
            newElement.currentMin = number;
        }
        stack.push(newElement);
    }

    public int getMin() {
        if(!stack.isEmpty()){
            return stack.peek().currentMin;
        }
        return -1;
    }

    public int getMax() {
        if(!stack.isEmpty()){
            return stack.peek().currentMax;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinMaxStack stack = new MinMaxStack();

        stack.push(2);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());

        stack.push(7);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());

        stack.push(1);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());


        stack.push(8);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());

        stack.push(3);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());

        stack.push(9);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());


        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());


        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());

    }

}
