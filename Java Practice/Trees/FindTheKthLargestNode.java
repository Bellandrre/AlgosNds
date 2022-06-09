package Trees;
import java.util.PriorityQueue;
import java.util.concurrent.*;
public class FindTheKthLargestNode {


    PriorityQueue<BST> queue = new PriorityQueue<>((a,b) -> a.value - b.value);
    int k;
    static class BST{
        int value;
        public BST left;
        public BST right;

        public BST(int value){
            this.value = value;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        this.k = k;
        findKthLargestValueInBstHelper(tree);

        while(this.k != 1){
            queue.poll();
            k--;
        }

        return queue.poll().value;
    }

    // Queue - [17, 20, 22]
    public void findKthLargestValueInBstHelper(BST root){

        if(root != null){
            findKthLargestValueInBstHelper(root.left);
            if(queue.size() == this.k){
                if(root.value > queue.peek().value){
                    queue.poll();
                    queue.add(root);
                }
            }else{
                queue.add(root);
            }
            findKthLargestValueInBstHelper(root.right);
        }
    }


    public static void main(String[] args) {
        BST tree = new BST(15);
        tree.right = new BST(20);
        tree.right.left = new BST(17);
        tree.right.right = new BST(22);

        tree.left = new BST(5);
        tree.left.right = new BST(5);

        tree.left.left = new BST(2);
        tree.left.left.right = new BST(3);
        tree.left.left.left = new BST(1);

        FindTheKthLargestNode obj = new FindTheKthLargestNode();

        System.out.println(obj.findKthLargestValueInBst(tree, 3));
        Executor exe;
    }

}
