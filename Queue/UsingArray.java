package Queue;

public class UsingArray {
    static int arr[];
    static int size;
    static int rear;

    UsingArray(int n){
        arr = new int[n];
        size = n;
        rear = -1;
    }

    public boolean isEmpty(){
        return rear==-1;
    }

    //add
    public void add(int data){
        if(rear == size-1){
            System.out.println("Queue is full");
            return;
        }
        rear = rear+1;
        arr[rear] = data;
    }

    //remove
    public int remove(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }

        int front = arr[0];
        for(int i=0; i<rear; i++){
            arr[i] = arr[i+1];
        }
        rear-=1;
        return front;

    }

    //peek
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }

        return arr[0];
    }

    public static void main(String[] args) {
        UsingArray q = new UsingArray(5);
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
