package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1965_상자넣기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int idx = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            int temp = idx - 1;
            while (temp >= 0 && arr[temp] >= num) {
                temp--;
            }
            arr[temp + 1] = num;
            if (idx == temp + 1) idx++;
        }

        System.out.println(idx);
        br.close();
    }
}
