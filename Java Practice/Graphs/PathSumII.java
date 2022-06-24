package Graphs;


import java.util.*;

public class PathSumII {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfSHelper(result, new ArrayList<>(), root, targetSum, 0, new HashSet<>());
        return result;
    }

    public static void dfSHelper(List<List<Integer>> result, List<Integer> resultSoFar, TreeNode root, int targetSum, int sumSoFar, Set<TreeNode> visited){
        if(root == null){
            return;
        }

        sumSoFar += root.val;
        resultSoFar.add(root.val);

        if(sumSoFar == targetSum){

            result.add(new ArrayList<>(resultSoFar));
            return;
        }

        dfSHelper(result, resultSoFar, root.left, targetSum, sumSoFar, visited);
            if(root.left != null) {
               // sumSoFar -= root.left.val;
                resultSoFar.remove(resultSoFar.size() - 1);
            }
        dfSHelper(result, resultSoFar, root.right, targetSum, sumSoFar, visited);
            if(root.right != null) {
               // sumSoFar -= root.right.val;
                resultSoFar.remove(resultSoFar.size() - 1);
            }
    }

    public static void main(String[] args) {
        TreeNode newNode = new TreeNode(1);
        newNode.left = new TreeNode(2);

        System.out.println(pathSum(newNode, 1));

    }

}
