package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12970_AB {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> aLoc = new ArrayList<>();
        int lastIndex = N;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < lastIndex; j++) {
                if (K == j) {
                    i = N;
                    K = 0;
                    aLoc.add(N - 1 - j);
                    break;
                }

                if (j == N - 1 - i) {
                    K -= j - 1 - aLoc.size();
                    lastIndex = j;
                    aLoc.add(N - 1 - j);
                }
            }
        }

        if (K != 0) {
            System.out.println(-1);
        } else {
            char[] arr = new char[N];
            Arrays.fill(arr, 'B');
            for (int i : aLoc) {
                arr[i] = 'A';
            }
            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                sb.append(c);
            }
            System.out.println(sb);
        }

        br.close();
    }
}
