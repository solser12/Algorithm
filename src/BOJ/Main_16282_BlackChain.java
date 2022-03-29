package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16282_BlackChain {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        int ans = 0;
        long bit = 2;
        while (true) {

            if (bit * (ans + 1) - 1 >= n) {
                break;
            }

            bit <<= 1;
            ans++;
        }

        System.out.println(ans);
        br.close();
    }
}