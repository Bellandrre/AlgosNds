package DataStructure;



public class ObjectStack {
	static int top;
	static int size;
	private People[] stack;
	
	public ObjectStack() {
		top=-1;
		size=50;
		stack = new People[size]; 
	}
	
	
	public ObjectStack(int size){
		top=-1;
		this.size=size;
		stack= new People[this.size];
	}
	
	public boolean isFull(){
		return (top==stack.length-1);
	}
	
	
	public boolean isEmpty(){
		return (top==-1);
	}
	
	public boolean push(People ppl){
		if(!isFull()){
			top++;
			stack[top]=ppl;
			return true;
		}
		else
			return false;
	}
	
	public People pop(){
		
		return stack[top--];
		
	}
		public static void main(String[] args) {
			People p = new People("Karthik","29");
			People q = new People("Drishte", "24");
			ObjectStack os = new ObjectStack();
			
			os.push(p);
			os.push(q);
			
			System.out.println(p.toString());
			System.out.println(q.toString());
			
			System.out.println(os.pop().toString());
			
			
		}
	
	

}
