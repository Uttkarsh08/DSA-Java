package LinkedList.Singly;

public class Reverse {
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

    public static void reverseLL(){
        Node cur = head;
        Node prev = null;
        Node nxt;

        while(cur != null){
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
            
        }
        head = prev;
        printLL();
    }

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

    public static void main(String[] args) {
        Reverse ll = new Reverse();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        printLL();
        reverseLL();
    }
}
