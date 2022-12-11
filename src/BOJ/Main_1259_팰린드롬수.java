package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1259_팰린드롬수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while (!(str = br.readLine()).equals("0")) {
            int left = 0, right = str.length() - 1;
            boolean isPalindrome = true;
            while (left <= right) {
                if (str.charAt(left) != str.charAt(right)) {
                    isPalindrome = false;
                    break;
                }
                left++;
                right--;
            }

            sb.append(isPalindrome ? "yes" : "no").append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}
