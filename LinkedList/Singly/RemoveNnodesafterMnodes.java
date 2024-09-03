package LinkedList.Singly;

public class RemoveNnodesafterMnodes {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public void addFirst(int data) {

        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public static void printLL(){
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static int getLength(){
        int len = 0;
        Node cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        return len;
    }

    public static void Remove(int n, int m){
        Node cur = head;
        Node nxt;
        int count;
        while(cur != null){
            for(count = 1; count < m && cur != null; count++){
                cur = cur.next;
            }
            if(cur == null){
                return;
            }
            nxt = cur.next;
            for(count = 1; count <=n && nxt != null; count++){
                Node temp = nxt; // not necessary
                nxt = nxt.next;
                temp.next = null;//
            }

            cur.next = nxt;

            cur = nxt;
            printLL();
    
        }

    }

    public static void main(String[] args) {
        RemoveNnodesafterMnodes ll = new RemoveNnodesafterMnodes();
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        printLL();
       Remove(2,1);
    }
}

