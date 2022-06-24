package Graphs;
import java.util.*;

public class BinaryTreeMaximumPathSum {

    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val){
            this.val = val;
        }
    }

    static int maxGain = Integer.MIN_VALUE;


    public static int maxPathSum(TreeNode root){
        if(root != null){
            maxPathSumHelper(root);
        }

        return maxGain == Integer.MAX_VALUE ? 0 : maxGain;
    }

    public static int maxPathSumHelper(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftSum  = maxPathSumHelper(root.left);
        int rightSum = maxPathSumHelper(root.right);

        maxGain = Math.max(maxGain, Math.max(Math.max(leftSum, rightSum) + root.val,
                           root.val + leftSum + rightSum));

        return Math.max(leftSum, rightSum) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(-1);
        root.right = new TreeNode(-2);

        System.out.println(maxPathSum(root));

    }

}
