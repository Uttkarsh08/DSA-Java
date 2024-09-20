package Arrays.Array_2D;

public class AvgWaitingTime {
    
    public static int Time(int arr[][]){
        int cur_time = 0;
        int total = 0;
        for(int customer[]: arr){
            int arrival = customer[0];
            int service = customer[1];
            if(cur_time < arrival){
                cur_time = arrival;
            }
            int wait_time = cur_time+service-arrival;
            total+=wait_time;
            cur_time+=service;
        }
        return total/arr.length;
        
    }
    public static void main(String[] args) {
        int arr[][] = {
            {1,2},
            {2,5},
            {4,3}
        };
        System.out.println(Time(arr));
    }
}
