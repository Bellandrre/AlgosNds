/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        // easy to use Deque as we can poll/ push either side
        Deque<Node> que = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        que.add(root);
        
        while(!que.isEmpty()){ // doing a basic level order traversal for Nary tree
            List<Integer> temp = new ArrayList<>();
            int size = que.size();
            for(int i = 0 ; i < size ;i++){
                Node curr = que.poll();
                temp.add(curr.val);
                for(Node n : curr.children){                    
                    que.offer(n);
                }
            }
            result.add(temp);
        }
        return result;
    }
}