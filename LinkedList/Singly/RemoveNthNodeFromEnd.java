package LinkedList.Singly;

public class RemoveNthNodeFromEnd {
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

    public static void Remove(int n){
        int len = getLength();
        int index = len-n;
        Node prev = null;
        Node cur = head;
        while(index > 0){
            prev = cur;
            cur = cur.next;
            index--;
        }
        prev.next = cur.next;
        printLL();
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd ll = new RemoveNthNodeFromEnd();
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        printLL();
        Remove(2);
    }
}
