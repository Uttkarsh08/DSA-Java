
public class Shortestpath {
    public static float Displacement(String str){
        int y=0;
        int x =0;
        int n = str.length()-1;
        for(int i=0; i<=n; i++){
            char a = str.charAt(i);
            if(a=='E') x--;
            if(a=='W') x++;
            if(a=='N') y++;
            if(a=='S')y--;
        }
        int l = x*x;
        int m = y*y;
        System.out.print("Shortest Distance = ");
        return (float)Math.sqrt(l+m);

    }
    public static void main(String[] args) {
        String str = "WNEENESENNN";
        System.out.println(Displacement(str));
    }
}
