package Stack;

import java.util.Stack;

public class PalindromeLL {
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
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
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
    public static boolean isPalindrome(Node head){
        Stack<Integer> s = new Stack<>();
        Node cur = head;
        boolean ans = true;
        while(cur!= null){
            s.push(cur.data);
            cur = cur.next;
        }
        while(head != null){
            int i = s.pop();
            if(head.data != i){
                ans = false; 
                break;
            }
            head = head.next;
        }
        return ans;
    }
    public static void main(String[] args) {
        PalindromeLL ll = new PalindromeLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);

        System.out.println(isPalindrome(head));
    }
}
