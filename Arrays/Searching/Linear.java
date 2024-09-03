package Arrays.Searching;

public class Linear {
    public static int  LinearSeacrh(int numbers[], int key){
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == key){
                return i;
            }

        }
        return -1;
    }
    public static void main(String[] args){
        int numbers[] = {2,3,4,10,15,13,9};
        int key = 15;
        System.out.println(LinearSeacrh(numbers, key));
    }
    
}
