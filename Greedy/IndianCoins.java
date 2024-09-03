package Greedy;

import java.util.*;


public class IndianCoins {
    public static void main(String[] args) {
        int notes[]  = {1,2,5,10,20,50,100,500,2000};
        int val = 590;
        int ans =  0;
        Arrays.sort(notes);
        for(int i=notes.length-1; i>=0; i--){
            if(notes[i] <= val){
                while(notes[i] <= val){
                    val -= notes[i];
                    ans++;
                }
                
            }
        }
        System.out.println("Minimum Notes = " + ans);
    }
}
