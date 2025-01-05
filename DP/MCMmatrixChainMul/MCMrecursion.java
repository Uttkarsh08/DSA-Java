package DP.MCMmatrixChainMul;

public class MCMrecursion {
    public static int mcm(int[] arr, int i, int j){
        if(i==j) return 0; //base case(we have only one mtrix for multiplication)
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){ //upto j-1(every posiible cut to find different wqays to multiply the matrices)
            //divide the matrices A1, A2, An-1 into 2 subproblems and get answer with recursion.

            int cost1 = mcm(arr, i, k);  //dim -> arr[i-1] X arr[k];
            int cost2 = mcm(arr, k+1, j);  //dim -> arr[k] X arr[j];

            int cost3 = arr[i-1]*arr[k]*arr[j];

            int finalcost = cost1+cost2+cost3;
            
            ans = Math.min(ans, finalcost);
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,3};

        System.out.println(mcm(arr, 1, arr.length-1));
    }
}
