package Others;

import java.util.Scanner;

// at least one -> special character, number, lowercase char, uppercase char 
public class checkPassword {

    public static String validatePass(String pass) {
        boolean special = false, num = false, lower = false, upper = false;
        int len = 0;
        for (char ch : pass.toCharArray()) {

            if (lower && upper && num && special && len >= 8)
                break;
            if (ch == ' ')
                continue;
            if (ch >= 'a' && ch <= 'z')
                lower = true;
            if (ch >= 'A' && ch <= 'Z')
                upper = true;
            if (ch >= '0' && ch <= '9')
                num = true;
            else
                special = true;

            len++;

        }
        String ans = "";
        if (!lower)
            ans += "pass must contain a lowercase Character \n";
        if (!upper)
            ans += "pass must contain a UpperCase Character \n";
        if (!num)
            ans += "pass must contain a number \n";
        if (!special)
            ans += "pass must contain a special Character \n";
        if (len < 8)
            ans += "pass must at least of 8 Character";

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pass = sc.nextLine();

        sc.close();

        System.out.println(validatePass(pass));
    }
}
