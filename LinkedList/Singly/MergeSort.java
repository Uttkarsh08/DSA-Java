package LinkedList.Singly;

public class MergeSort {
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

    public static void PrintLL(){
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

    //Merge Sort
    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        //find mid
        Node slow = head;
        Node fast = head.next; // head.next so that slow get upto  last node of left(1st) half, which is mid
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //divide them into two halfs
        Node mid = slow;
        Node head1 = head;
        Node head2 = mid.next;
        mid.next = null;

        //sort both halfs
        Node lefthead = mergeSort(head1);
        Node righthead = mergeSort(head2);

        return merge(lefthead, righthead);
    }

    public static Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public static void main(String[] args) {
        MergeSort ll = new MergeSort();
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(1);
        ll.addFirst(4);

        PrintLL();
        head = mergeSort(head);
        PrintLL();
    }
}
