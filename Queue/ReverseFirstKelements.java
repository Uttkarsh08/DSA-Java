package Queue;

import java.util.*;

public class ReverseFirstKelements {
    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) { // space and time - O(n)
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        while(k>0){
            k--;
            s.push(q.remove());
            
        }
        while(!q.isEmpty()){
            q2.add(q.remove());
        }
        
        while(!s.isEmpty()){
            q.add(s.pop());
        }
        while(!q2.isEmpty()){
            q.add(q2.remove());
        }
        return q;
    }

    public static Queue<Integer> modifyQueue2(Queue<Integer> q, int k) { // time - O(n), space - O(k) (space for recursive stack)
        solve(q, k);
        int s = q.size()-k;
        while (s-- > 0) {
            int b =q.poll();
            q.add(b);
        }
        return q;
    }
    public static void solve(Queue<Integer> q, int k){
        if(k==0) return;
        int a = q.poll();
        solve(q, k-1);
        q.add(a);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        // System.out.println(modifyQueue(q, 3));
        System.out.println(modifyQueue2(q, 3));
    }
}
