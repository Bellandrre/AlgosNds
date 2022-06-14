package Trees;
import java.util.*;

public class PostFixTraversal {

    static abstract class Node{
        public abstract int evaluate();
        Node left;
        Node right;
        char value;
    }

    static class TreeBuilder extends Node {

        public int evaluate(){
            return 0;
        }

        // {"4", "5", "2", "7", "+", "-", "*"}
        //                                 ^
        // stack = [ "-16"]

        // R = -4
        // L = 4
        int buildTree(String[] postfix) {
            Stack<String> stack = new Stack<>();

            for(int i = 0 ; i < postfix.length ; i++){
                Character currChar = postfix[i].charAt(0); // 2
                if(Character.isDigit(currChar)){
                    stack.push(currChar + "");
                }else{
                    if(!stack.isEmpty()){
                        int rightDigit = Integer.parseInt(stack.pop());
                        if(!stack.isEmpty()){
                            int leftDigit = Integer.parseInt(stack.pop());

                            if(currChar == '+'){
                                stack.push((rightDigit + leftDigit) + "");
                            }else if(currChar == '-'){
                                stack.push((leftDigit - rightDigit) + "");
                            }else if(currChar == '*'){
                                stack.push((leftDigit * rightDigit) + "");
                            }else{
                                stack.push((leftDigit / rightDigit) + "");
                            }
                        }
                    }
                }
            }
            return Integer.parseInt(stack.peek());
        }
    };

    public static void main(String[] args) {
        String[] postFix = {"3", "4", "+", "2", "*", "7", "/"};
        TreeBuilder obj = new TreeBuilder();
        System.out.println(obj.buildTree(postFix));
    }

}
