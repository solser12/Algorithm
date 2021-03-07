package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2493_탑 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        int[] loc = new int[N];
        int input, top = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; ++i) {
            input = (Integer.parseInt(st.nextToken()));

            while (top != 0) {
                if (stack[top-1] > input) {
                    sb.append(loc[top-1]).append(' ');
                    stack[top] = input;
                    loc[top++] = i;
                    break;
                }
                top--;
            }

            if  (top == 0) {
                sb.append("0 ");
                stack[top] = input;
                loc[top++] = i;
                continue;
            }
        }

        sb.append('\n');

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
