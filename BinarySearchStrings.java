import java.util.Scanner;

public class BinarySearchStrings{
	static String s;
	class Node{
		String key;
		Node left,right;
		public Node(String item){
			key=item;
			left=null;right=null;
			
		}
		
	}
	
	Node root;
	
	public BinarySearchStrings() {
		root=null;
	}
	
	public void insert(String key){
		root=insertRec(root,key);
	}

	public Node insertRec(Node root, String key) {
		if(root== null){
			root=new Node(key);
			return root;
		}
		if(key.compareToIgnoreCase(root.key.toString())<0){
			root.left= insertRec(root.left,key);
		}
		
		else if(key.compareToIgnoreCase(root.key.toString())>0){
			root.right= insertRec(root.right,key);
		}
		
		return root;
	}
	
	void traverse(){
		//inOrder(root);
		inorderSearch(root);
		
	}

	private void inOrder(Node root) {
		if(root!=null){
			inOrder(root.left);
			//System.out.println(root.key);
			inOrder(root.right);
			
		}
		
		
		
	
		
	}
	
	
	
	void inorderSearch(Node root){
		if(root!=null){
			inOrder(root.left);
			if(root.key.equals(s)){ System.out.println("Yes");}
			else System.out.println("No");
			inOrder(root.right);
			
		}
		
	}
	
	public static void main(String[] args) {
		BinarySearchStrings bs=new BinarySearchStrings();
		bs.insert("Z");
		bs.insert("A");
		bs.insert("Y");
		bs.insert("B");
		bs.insert("X");
		bs.insert("C");
		Scanner sc =new Scanner(System.in);
		s=sc.next();
		sc.close();
		bs.traverse();
	}
}