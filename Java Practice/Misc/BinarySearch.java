import java.util.*;
public class BinarySearch {
	static List <Integer> left = new ArrayList<>();
	static List <Integer> right = new ArrayList<>();
	static List<Integer> result = new ArrayList<>();
	class Node{
		
		int key;
		Node left;
		Node right;
		
		public Node(int data){
			key = data;
			right = left = null;
		}
	}
	
	Node root;
	
	public BinarySearch(){
		root = null;
	}
	
	public void insert(int element){
		root = insertRec(root, element);
	}
	
	public Node insertRec(Node root, int element){
		if(root==null){
			root = new Node(element);
			return root;
		}
		
		if (root.key > element){
			root.left = insertRec(root.left, element);
		}
		
		else if(root.key < element){
			root.right = insertRec(root.right, element);
		}
		
		
		return root;
	}
	
	public void traverse(){
		inOrder(root);
	}
	
	public void inOrder(Node root){
		if(root!=null){
			result.add(root.key);
			
			inOrder(root.left);
			
			inOrder(root.right);
			
			
			
		}
	}
	
	public void search(int search){
		Node k = inOrderSearch(root,search);
		if(k != null){
			System.out.println("Yes");
			}
		else
			System.out.println("No");
	}
	
	public Node inOrderSearch(Node root, int key){
		 if (root==null || root.key==key)
		        return root;
		 
		    // val is greater than root's key
		    if (root.key > key)
		        return inOrderSearch(root.left, key);
		 
		    // val is less than root's key
		    return inOrderSearch(root.right, key);
		
		
	}
	
	
	public boolean checkBST(){
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	
	}
	
	
	private boolean isBST(Node root, int minValue, int maxValue) {
		if(root == null){
			return true;
		}
		
		if(root.key<minValue || root.key>maxValue){
			return false;
		}
		
		else
			return (isBST(root.left,minValue,root.key-1) && (isBST(root.right,root.key+1,maxValue)));
		
		
		
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		bs.insert(1);
		bs.insert(3);
		bs.insert(2);
	
		
		
	/*	
		bs.search(10);*/
		bs.traverse();
		
		for(Integer x:result) {
			System.out.println(x);
		}
		
		
		/*System.out.println("Is it a binary tree -" +bs.checkBST());*/
		
	}
	
	
	
	
}
