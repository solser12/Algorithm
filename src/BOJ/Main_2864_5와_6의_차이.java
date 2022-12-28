package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2864_5와_6의_차이 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int maxSum = 0, minSum = 0;
        int  digit = 1;
        for (int i = A.length() - 1; i >= 0; i--) {
            char c = A.charAt(i);
            if (c == '5' || c == '6') {
                maxSum += 6 * digit;
                minSum += 5 * digit;
            } else {
                maxSum += (c - '0') * digit;
                minSum += (c - '0') * digit;
            }
            digit *= 10;
        }

        digit = 1;
        for (int i = B.length() - 1; i >= 0; i--) {
            char c = B.charAt(i);
            if (c == '5' || c == '6') {
                maxSum += 6 * digit;
                minSum += 5 * digit;
            } else {
                maxSum += (c - '0') * digit;
                minSum += (c - '0') * digit;
            }
            digit *= 10;
        }

        System.out.println(minSum + " " + maxSum);
        br.close();
    }
}
