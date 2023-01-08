package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2562_최댓값 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.MIN_VALUE;
        int loc = 0;
        for (int i = 1; i <= 9; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (num < temp) {
                num = temp;
                loc = i;
            }
        }

        System.out.println(num);
        System.out.println(loc);
        br.close();
    }
}
