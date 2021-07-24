
public class CheckBinary {
	class Node{
		int key;
		Node left;
		Node right;
		
		public Node(int item) {
			// TODO Auto-generated constructor stub
			key=item;
			left=right=null;
		}
	}
	
	
	Node root = null;
	
	public void insert(int key){
		root = insertRec(root,key);
	}

	private Node insertRec(Node root, int key) {
		if(root==null){
			root= new Node(key);
			return root;
		}
		if(key < root.key){
			root.left=insertRec(root.left, key);
		}
		if(key>root.key){
			root.right=insertRec(root.right, key);
		}
		
		return root;
	}
	
	public void traverse(){
		inorder(root);
	}

	private void inorder(Node root) {
		if(root!=null){
			inorder(root.left);
			System.out.println(root.key);
			inorder(root.right);
			
		}
		
	}
	
	private boolean isBST(){
		return isBSTUtil(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private boolean isBSTUtil(Node root, int minValue, int maxValue) {
		// TODO Auto-generated method stub
		if(root==null){
			return true;
		}
		if(root.key<minValue && root.key>maxValue){
			return false;
		}
		else return (isBSTUtil(root.left,minValue, root.key-1) && isBSTUtil(root.right,root.key+1, maxValue));
		
		
	}

	

	
	public static void main(String[] args) {
		CheckBinary cb= new CheckBinary();
		for(int i = 0 ;i<5;i++){
			double d = Math.random()*110;
			int c = (int) Math.round(d);
			cb.insert(c);
		}
		
		
		
		//cb.traverse();
		
		System.out.println(cb.isBST());
	}
	

}
