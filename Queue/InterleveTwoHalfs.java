package Queue;

import java.util.LinkedList;
import java.util.Queue;

//GFG

public class InterleveTwoHalfs {

    public static Queue<Integer> rearrangeQueue(Queue<Integer> q) {
        Queue<Integer> first = new LinkedList<>();
        int size = q.size();
        for(int i=0; i<size/2; i++){ 
            first.add(q.remove());
        }
        
        while(!first.isEmpty()){
            q.add(first.remove());
            q.add(q.remove());
        }
        return q;
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(2);
        q.add(4);
        q.add(3);
        q.add(1);
        System.out.println(rearrangeQueue(q));
    }
}
