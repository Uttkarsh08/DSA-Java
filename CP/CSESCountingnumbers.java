package CP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CSESCountingnumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> digitn = new ArrayList<>();
        ArrayList<Integer> digitm = new ArrayList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();

        getDigits(n-1, digitn);
        getDigits(m, digitm);

        System.out.println(Sol(digitn, digitm, n, m));

        sc.close();
    }

    public static int Sol(ArrayList<Integer> digitn, ArrayList<Integer> digitm, int n, int m){
        int a = NumbersSmallerThanit(digitn, 0, true, true, -1);
        int b = NumbersSmallerThanit(digitm, 0, true, true, -1);

        return b-a;
    }

    public static int NumbersSmallerThanit(ArrayList<Integer> digit, int i, boolean tight, boolean lz, int prev){
        if(i>=digit.size()){
            return 1;
        }
        int up = tight? digit.get(i): 9;
        int ans=0;
        for(int idx=0; idx<=up; idx++){
            if(lz || idx != prev){
                ans += NumbersSmallerThanit(digit, i+1, tight&&(idx==up), lz&& idx==0, idx);
            }
        }
        return ans;
    }

    public static void getDigits(int x, ArrayList<Integer> digit)
    {
        if (x == 0) {
            digit.add(0);
            return;
        }
        while (x > 0) {
            digit.add(x % 10);
            x /= 10;
        }
        Collections.reverse(digit);
    }

}
