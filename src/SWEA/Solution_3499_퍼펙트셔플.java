package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Solution_3499_퍼펙트셔플 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N, T = 10;
        String input;
        int[] postfix;
        char[] operator;
        int ptop, otop;

        for (int tc = 1; tc <= T; ++tc) {

            N = Integer.parseInt(br.readLine());
            input = br.readLine();

            postfix = new int[N/2+1];
            operator = new char[N/2];
            ptop = 0; otop = 0;

            for (int i = 0; i < N; ++i) {
                char data = input.charAt(i);

                if (data == '+' || data == '*') {
                    while (true) {
                        if (otop == 0 || (data == '*' && operator[otop - 1] == '+')) {
                            operator[otop++] = data;
                            break;
                        }
                        else {
                            int sum = calc(operator[--otop], postfix[--ptop], postfix[--ptop]);
                            postfix[ptop++] = sum;
                        }
                    }
                }
                else {
                    postfix[ptop++] = (int) data - 48;


                }
            }

            while (otop != 0) {
                int sum = calc(operator[--otop], postfix[--ptop], postfix[--ptop]);
                postfix[ptop++] = sum;
            }

            sb.append('#').append(tc).append(' ').append(postfix[--ptop]).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static int calc (char c, int num1, int num2) {
        if (c == '+') return num1 + num2;
        return num1 * num2;
    }
}
