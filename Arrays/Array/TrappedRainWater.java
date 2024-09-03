package Arrays.Array;

public class TrappedRainWater {
    // public static int trap(int[] height) {
    //     int n = height.length;
    //     int wl = 0;
    //     int a=0;
    //     int ans=0;
    //    if(n <=2) return 0;
    //    int leftmax[] = new int[n];
    //    int rightmax[] = new int[n];
    //    for(int i=0; i<n; i++){
    //     if(i==0) leftmax[i] = height[i];
    //     else leftmax[i] = Math.max(height[i], leftmax[i-1]);
    //    }
    //    for(int i=n-1; i>=0 ;i--){
    //     if(i==n-1) rightmax[i] = height[i];
    //     else rightmax[i] = Math.max(height[i], rightmax[i+1]);
    //    }
    //     for(int i=0; i<n; i++){
    //         wl = Math.min(leftmax[i], rightmax[i]);
    //         a =(wl-height[i]);
    //         if(a <0){    // will never be negative
    //             a=0;
    //         }
    //         ans+=a;
    //     }
    //     return ans;
    // }
    public static int trap(int[] height) {
        int maxLevel = 0;
        int ans = 0;
        int h = height.length;
        int leftMax[] = new int[h];
        int rightMax[] = new int[h];
        leftMax[0]= height[0];
        rightMax[h-1]= height[h-1];
        for(int i=1; i<h; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        for(int i=h-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        for(int i=0; i<h; i++){
            maxLevel = Math.min(leftMax[i], rightMax[i]);
            ans+=maxLevel-height[i];
        }
        return ans;

    }
    public static void main(String[] args) {
       int height[]  = {4,2,0,6,3,2,5};
       System.out.println(trap(height));

    }
    
}
    
