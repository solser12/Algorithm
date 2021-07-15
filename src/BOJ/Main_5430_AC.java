package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5430_AC {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            char[] p = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            boolean isReverse = false;
            boolean isError = false;
            int fPoint = 0, bPoint = n - 1;

            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input.substring(1, input.length() - 1), ",");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (char c : p) {
                if (c == 'R') {
                    isReverse = !isReverse;
                } else {
                    if (fPoint > bPoint) {
                        sb.append("error\n");
                        isError = true;
                        break;
                    }

                    if (isReverse) {
                        bPoint--;
                    } else {
                        fPoint++;
                    }
                }
            }

            if (!isError) {
                sb.append('[');
                if (n > 0) {
                    if (isReverse) {
                        for (int i = bPoint; i >= fPoint; i--) {
                            sb.append(arr[i]);
                            if (i != fPoint) sb.append(',');
                        }
                    } else {
                        for (int i = fPoint; i <= bPoint; i++) {
                            sb.append(arr[i]);
                            if (i != bPoint) sb.append(',');
                        }
                    }
                }
                sb.append("]\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
