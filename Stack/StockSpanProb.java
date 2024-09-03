package Stack;

import java.util.Stack;

public class StockSpanProb {

    public static int[] stockSpan(int stocks[]){
        int[] spans = new int[stocks.length];
        Stack<Integer> s = new Stack<>();
        spans[0] = 1;
        s.push(0); // 0 is the index of 1st stock

        for(int i=1; i<stocks.length; i++){ // iterate throught each stock
            while(!s.isEmpty() && stocks[i] > stocks[s.peek()]){  // check for previous high
                s.pop();
            }
            if(s.isEmpty()){
                spans[i] = i+1;
            }else{
                int prevHigh = s.peek();
                spans[i] = i-prevHigh;  // update span array
            }
            s.push(i);  //push index of current stock if ther is not any other stock les than this in stack(which is checked by while loop)
            
        }
        return spans;
    }

    //CHECK AGAIN

    // public static int[] stockSpan2(int[] stocks) {
    //     Stack<Integer> stack = new Stack<>();
    //     int[] result = new int[stocks.length];

    //     for (int i = 0; i < stocks.length; i++) {
    //         while (!stack.isEmpty() && stocks[i] > stocks[stack.peek()]) {
    //             int idx = stack.pop();
    //             result[idx] = i - idx;
    //         }
    //         stack.push(i);
    //     }

    //     return result;        
    // }

    public static void main(String[] args) { 
        int[] stocks = {100,80,60,70,60,85,100};
        int[] ans = stockSpan(stocks);
        // int[] ans2 = stockSpan2(stocks);
        for(int i : ans){
            System.out.print(i+" ");
        }
        // System.out.println();
        // System.out.println("------------------------------------");
        // for(int i : ans2){
        //     System.out.print(i+" ");
        // }
    }
}
