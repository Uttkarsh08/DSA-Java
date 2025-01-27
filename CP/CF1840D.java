package CP;

import java.util.*;

public class CF1840D {
    public static int minimumWaitingTime(int[] arr){
        Arrays.sort(arr);
        int s = 0;
        int e = arr[arr.length-1]-arr[0];
        int ans = e;
        while (s<=e) {
            int mid = s+(e-s)/2;
            if(isPossible(arr, mid)){
                ans = mid;
                e=mid-1;
            }else s=mid+1;
        }
        
        return ans;
    }

    public static boolean isPossible(int[] arr, int w){
        int numberofworkers =1;
        int lastoc = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > lastoc+ 2* w){
                numberofworkers++;
                lastoc = arr[i];

                if(numberofworkers > 3) return false;
            }
        }
        return true;
    
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(minimumWaitingTime(arr));
        }
        sc.close();
    }
}
