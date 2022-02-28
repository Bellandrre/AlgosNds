package Graphs;

public class RangeSum {

    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(){}
        public TreeNode(int value){
            this.value = value;
        }
    }

    static int sum;

    public static int rangeSum(TreeNode root, int low, int high){
        sum = 0;
        rangeSumHelper(root, low, high);
        return sum;
    }

    public static void rangeSumHelper(TreeNode root, int low, int high){
        if(root != null){
            if(root.value >= low && root.value <= high){
                sum += root.value;
            }
            if(root.value > low)
                rangeSumHelper(root.left, low, high );
            if(root.value < high)
                rangeSumHelper(root.right, low, high);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.value = 10;
        root.left = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        int sum = rangeSum(root, 7, 15);
        System.out.println("Sum is "+ sum);

    }


}
