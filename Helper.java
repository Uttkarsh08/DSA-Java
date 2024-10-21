import java.util.HashSet;
import java.util.Iterator;


public class Helper {
       
    public static void main(String[] args) {
        String s = "wwwzfvedwfvhsww"; // Test case
        HashSet<Character> hash = new HashSet<>();
        int ans = 0;  // Count of unique characters or substrings
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); // Current character
            
            if (!hash.contains(ch)) {
                // If the character is not in the set, add it and increment ans
                hash.add(ch);
                ans++;
            } else {
                // If the character is already in the set, clear the set and restart for a new substring
                hash.clear();
                hash.add(ch); // Add the current character after clearing
                ans++;  // Each new unique substring still counts
            }
        }

        System.out.println(ans); // Output the result
    }
}

