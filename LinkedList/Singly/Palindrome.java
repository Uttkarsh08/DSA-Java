package LinkedList.Singly;

public class Palindrome {
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
    public static Node findMid(Node head){
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPlaindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //find mid
        Node mid = findMid(head);

        //reverse second half
        Node prev = null;
        Node cur = mid;
        Node nxt;
        while(cur != null){
            nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        
        Node right = prev;
        Node left = head;

        //check left and right equality
        while(right != null){
            if(left.data != right.data) return false; 
            left = left.next;
            right= right.next;
        }
        return true;
    }

    

    public static void main(String[] args) {
        Palindrome ll = new Palindrome();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(2);
        ll.addFirst(1);
        printLL();
        System.out.println(ll.isPlaindrome());

    }
}
