package LinkedList.Singly;

public class Basics {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
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
        cur.next = newNode;
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

    public int SearchIterative(int key){
        Node cur = head;
        int i=0;

        while(cur.next != null){
            if(cur.data == key){
                return i;
            }
            cur = cur.next;
            i++;

        }
        return -1;
        
    }

    
    public int helper(Node head, int key){
        //base case
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int index = helper(head.next, key);
        if(index == -1){
            return index;
        }
        return index+1;
    }
    public int SearchRecursive(int key){
        return helper(head, key);
    }

    public static void main(String[] args) {
        Basics ll = new Basics();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        // ll.PrintLL();
        ll.Add(9, 2);
        // ll.PrintLL();
        // System.out.println("Size: "+ ll.size);

        // System.out.println(ll.SearchIterative(9));
        System.out.println(ll.SearchRecursive(9));
    }
}
