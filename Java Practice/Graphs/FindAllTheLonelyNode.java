package Graphs;
import java.util.List;
import java.util.ArrayList;
public class FindAllTheLonelyNode {

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
    }
    static List<Integer> resultList;
    public List<Integer> getLonelyNodes(TreeNode root) {
        resultList = new ArrayList<>();
        getLonelyNodesHelper(root);
        return resultList;
    }

    public static void getLonelyNodesHelper(TreeNode root){
        if(root == null)
            return;

        if(root.left != null && root.right == null){
            resultList.add(root.left.val);
        }
        if(root.right != null && root.left == null){
            resultList.add(root.right.val);
        }
        getLonelyNodesHelper(root.left);
        getLonelyNodesHelper(root.right);
    }

}
