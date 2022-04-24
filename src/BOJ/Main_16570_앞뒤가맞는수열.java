package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16570_앞뒤가맞는수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = N - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] table = new int[N];
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            while (j > 0 && arr[i] != arr[j]) {
                j = table[j - 1];
            }
            if (arr[i] == arr[j]) {
                table[i] = ++j;
            }
        }

        int size = 0, cnt = 0;
        for (int i : table) {
            if (i == 0) continue;

            if (size < i) {
                size = i;
                cnt = 1;
            } else if (size == i) {
                cnt++;
            }
        }

        if (size == 0) {
            System.out.println(-1);
        } else {
            System.out.println(size + " " + cnt);
        }

        br.close();
    }
}
