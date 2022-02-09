package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10266_시계사진들 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] first = new int[720000];
        int[] second = new int[360000];
        int[] table = new int[360000];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(st.nextToken());
            first[index] = 1;
            first[index + 360000] = 1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            second[Integer.parseInt(st.nextToken())] = 1;
        }

        int j = 0;
        for (int i = 1; i < 360000; i++) {
            while (j > 0 && second[i] != second[j]) {
                j = table[j - 1];
            }
            if (second[i] == second[j]) {
                table[i] = ++j;
            }
        }

        boolean ans = false;
        j = 0;
        for (int i = 0; i < 720000; i++) {
            while (j > 0 && first[i] != second[j]) {
                j = table[j - 1];
            }
            if (first[i] == second[j]) {
                if (j == second.length - 1) {
                    i = 72000;
                    ans = true;
                    break;
                } else {
                    j++;
                }
            }
        }

        System.out.println(ans ? "possible" : "impossible");
        br.close();
    }
}
