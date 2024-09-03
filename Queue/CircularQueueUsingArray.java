package Queue;

public class CircularQueueUsingArray {
    static int arr[];
    static int size;
    static int rear;
    static int front;

    CircularQueueUsingArray(int n){
        arr = new int[n];
        size = n;
        rear = -1;
        front = -1;
    }

    public boolean isEmpty(){
        return rear==-1;
    }
    public boolean isFull(){
        return (rear+1)%size == front;
    }

    //add
    public void add(int data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        if(front == -1){ // if 1st element is added
            front=0;
        }
        rear = (rear+1)%size;
        arr[rear] = data;
    }

    //remove
    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }

        int result = arr[front];

        if(rear == front){  // if last element is removed
            rear = front = -1;
        }else{
            front = (front+1)%size;
        }

        return result;

    }

    //peek
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }

        return arr[front];
    }

    public static void main(String[] args) {
        CircularQueueUsingArray q = new CircularQueueUsingArray(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
}
