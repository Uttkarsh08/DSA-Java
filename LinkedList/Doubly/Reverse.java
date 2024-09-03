package LinkedList.Doubly;

public class Reverse {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    public int getLength(){
        int len = 0;
        Node cur = head;
        while(cur.next != null){
            len++;
            cur = cur.next;
        }
        return len;
    }

    public void addFirst(int data) {

        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {

        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void Add(int data, int index){
        int len = getLength();
        if(index < 0 || index > len){
            System.out.println("Enter Valid Index");
        }
        if(index ==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node cur = head;
        while(index-1 > 0){
            index--;
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next.prev = newNode;
        cur.next = newNode;
        newNode.prev =  cur;
        
    }

    public void PrintLL(){
        if(head == null){
            System.out.println("LL is Empty");
            return;
        }
        Node cur = head;
        while(cur != null){
            System.out.print(cur.data +" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void reverse(){
        Node pre = null;
        Node cur = head;
        Node nxt;
        while(cur != null){
                nxt = cur.next;
                cur.next = pre;
                cur.prev = nxt;
                pre = cur;
                cur = nxt;

        }
        head = pre;
    }

    

    public static void main(String[] args) {
        Reverse ll = new Reverse();
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.PrintLL();
        
        ll.reverse();
        ll.PrintLL();

    }
}
