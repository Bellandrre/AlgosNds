
public class Inventory {
	Node item;
	class Node{
		int val;
		Node questItem;
		Node normalItem;
		
		public Node(int val) {
			this.val = val;
			questItem = null;
			normalItem = null;
		}
	}
	
	
	public Inventory() {
		item = null;
	}
	
	public boolean insertRec(int val) {
		Node newNode = new Node(val);
		if(item==null) {
			item = newNode;	
			return true;
		}
		
		else {
			Node focusNode;
			Node parent;
			focusNode = item;
			
			while(true) {
				parent = focusNode;
							
				if(val<=focusNode.val) {
					focusNode = focusNode.questItem;
					if(focusNode==null) {
						parent.questItem = newNode;
						return true;
					}
					
					
				}
				
				else {
					focusNode = focusNode.normalItem;
					if(focusNode==null) {
						parent.normalItem = newNode;
						return true;
					}
				}
				
			}
		}
		
		
	}
	
	
	public Node[] search(int val) {
		Node focusNode;
		Node parent = null;
		Node [] parentChild = new Node[2];
		focusNode = item;
		while(focusNode.val!=val) {
			parent = focusNode;
			if(val<focusNode.val) {
				focusNode = focusNode.questItem;
			}
			else {
				focusNode = focusNode.normalItem;
			}
			
			if(focusNode==null) {
				return null;
			}
			
		}
		if(parent!=null) {
		parentChild[0] = focusNode;
		parentChild[1] = parent;
		}
		else {
			parentChild[0] = focusNode;
			parentChild[1] = null;
		}
		if(parent!=null) {
		System.out.println("Found Node : " + focusNode.val + " with Parent value: "+ parent.val);
		}
		else {
			System.out.println("Single Found Node : " + focusNode.val);
		}
		return parentChild;
	}
	
	
	public boolean deleteNode(int val) {
	
		Node delete[] = search(val);
		Node nodeToDelete = delete[0];
		Node nodeToDelParent = delete[1];
		
		if(nodeToDelParent==null) {
			System.out.println("Loop 1");
			Node focus;
			
			if(nodeToDelete.questItem==null && nodeToDelete.normalItem==null) {
				item=null;
				System.out.println("Tree is now empty");
				return true;
			}
			
			if(nodeToDelete.questItem!=null && nodeToDelete.normalItem==null) {
				item = item.questItem;
				return true;
			}
			if(nodeToDelete.normalItem!=null && nodeToDelete.questItem==null) {
				item = item.normalItem;
				return true;
			}
			if(nodeToDelete.questItem!=null && nodeToDelete.normalItem!=null) {
				focus = nodeToDelete.normalItem;
				Node Parent = null;
				while(focus!=null) {
					Parent =focus;
					focus = focus.questItem;
				}
				//System.out.println(Parent.val);
				item.val = Parent.val;
				item.normalItem =null;
				
				return true;
			}
			

			
		}
		//Node has no children 
		if(nodeToDelete.questItem==null && nodeToDelete.normalItem==null) {
			System.out.println("Loop 2");
						
			if(val<nodeToDelParent.val) {
				nodeToDelParent.questItem = null;
			}
			else {
				nodeToDelParent.normalItem = null;
			}
			return true;
		}
		
		//Node has a single Child
		
		if(nodeToDelete.questItem!=null && nodeToDelete.normalItem==null) {
			System.out.println("Loop 3");
			Node focus;
			focus = nodeToDelete.questItem;
			if(val<nodeToDelParent.val) {
				nodeToDelParent.questItem = focus;
			}
			if(val>nodeToDelParent.val) {
				nodeToDelParent.normalItem = focus;
			}
			return true;
		}
		if(nodeToDelete.normalItem!=null && nodeToDelete.questItem==null) {
			Node focus;
			focus = nodeToDelete.normalItem;
			if(val<nodeToDelParent.val) {
				nodeToDelParent.questItem = focus;
			}
			if(val>nodeToDelParent.val) {
				nodeToDelParent.normalItem = focus;
			}
			return true;
		}
		
		
		
		if(nodeToDelete.questItem!=null && nodeToDelete.normalItem!=null) {
			System.out.println("Loop 4");
			Node focus;
			Node Parent = null;
			focus = nodeToDelete.normalItem;
			while(focus!=null) {
				Parent =focus;
				focus = focus.questItem;
			}
			//System.out.println(Parent.val);
			nodeToDelete.val = Parent.val;
			Parent =null;
			//System.out.println(Parent.val);
			return true;

		}

		
		return false;
	}
	
	
	public void inOrder() {
		inOrderTraversal(item);
	}
	
	public void inOrderTraversal(Node root) {
		if(root!=null) {
			inOrderTraversal(root.questItem);
			System.out.println(root.val);
			inOrderTraversal(root.normalItem);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Inventory tTree = new Inventory();
		tTree.insertRec(10);
		tTree.insertRec(9);
		tTree.insertRec(1);
		tTree.insertRec(80);
		tTree.insertRec(8);
		tTree.inOrder();
		
		//tTree.search(11);
		
		tTree.deleteNode(80);
		tTree.inOrder();
		
	}
	

}
