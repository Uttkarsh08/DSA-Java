package CP;
import java.util.*;

public class CF2051C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int[] ms = new int[m];
            for (int i = 0; i < m; i++) {
                ms[i] = sc.nextInt();
            }

            int[] yes = new int[n+1];
            for(int i=0; i<k; i++){
                int q = sc.nextInt();
                yes[q] = 1;
            }

            int dk=-1;
            int f = 0;

            for(int i=1; i<=n; i++){
                if(yes[i] == 0){
                    dk=i;
                    f++;
                }
            }

            if(f>1){
                System.out.print("0".repeat(m));
            }else if(f==0){
                System.out.print("1".repeat(m));
            }else{
                for(int i=0; i<m; i++){
                    if(ms[i] == dk){
                        System.out.print("1");
                    }else{
                        System.out.print("0");
                    }
                }
            }
            System.out.println();
        }

        sc.close();
    }
}



