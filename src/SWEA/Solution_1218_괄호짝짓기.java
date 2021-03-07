package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.StringBuilder;

public class Solution_1218_괄호짝짓기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] stack;
        char comp1, comp2;
        int top, N;
        String input;

        for (int tc = 1; tc <= 10; tc++) {

            N = Integer.parseInt(br.readLine());
            stack = new char[N];
            top = 0;

            input = br.readLine();

            for (int i = 0; i < N; i++) {
                if (top == 0) {
                    stack[top++] = input.charAt(i);
                    continue;
                }
                comp1 = input.charAt(i);
                comp2 = stack[top-1];
                if (comp2 != '(') {
                    if (comp2+2 == comp1) --top;
                    else stack[top++] = input.charAt(i);
                }
                else  {
                    if (comp2+1 == comp1) --top;
                    else stack[top++] = input.charAt(i);
                }
                if (top > N/2) break;
            }

            sb.append("#").append(tc).append(" ");

            if (top == 0) sb.append(1);
            else sb.append(0);

            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}
