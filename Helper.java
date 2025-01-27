class Helper {
    static int MOD = 1000000007;
    public static int countGoodNumbers(long n) {
       
        return (int)help(n, 0); 
    }

    public static long help(long n, int idx){
        if(idx == n){
            return 1;
        }
        long ans=0;
        for(int i=0; i<=9; i++){
            if(isValid(i, idx)){
                ans = (ans+help(n, idx+1))%MOD;
            }
        }
        return ans;
    }

    public static boolean isValid(int i, int idx){
        if(idx%2 == 0 && i%2 == 0) return true;
        if(idx%2 != 0 && isPrime(i)) return true;

        return false;
    }

    static boolean isPrime(int n){    
    if (n <= 1)     
           return false;    
       for (int i = 2; i <= Math.sqrt(n); i++)   
           if (n % i == 0)   
               return false;    
       return true;    
   }   
   public static void main(String[] args) {
    // System.out.println(countGoodNumbers(5));
    System.out.println(14/10);
    
   }
}