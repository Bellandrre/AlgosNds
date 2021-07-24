
public class Queue1 {
	private int queue[];
	private int front;
	private int rear;
	private int total;
	private int size;
	
	public Queue1(){
		size =100;
		 front=0;
		 rear=0;
		 total=0;
		 queue= new int[size];
	}
	
	public Queue1(int size){
		this.size=size;
		front=0;
		 rear=0;
		 total=0;
		 queue= new int[this.size];
	}
	
	public boolean enqueue(int element){
		if(isFull()){
			return false;
		}
		else{
			total++;
			queue[rear] = element;
			rear++;
			return true;
		}
			
		
	}
	
	public int dequeue (){
		if(isEmpty()){
			return 0;
		}
		else{
		int item = queue[front];
		total--;
		front++;
		return	item;
		}
		
		
	}
	
	
	public boolean isEmpty(){
		return rear == front;
		
	}
	public boolean isFull(){
		return rear == size-1;
	}
	
	public static void main(String[] args) {
		Queue1 q= new Queue1();
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		
		System.out.println(q.dequeue());
		
	}

}
