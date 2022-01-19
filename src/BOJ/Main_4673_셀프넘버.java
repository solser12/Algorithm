package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4673_셀프넘버 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] check = new boolean[10001];
        for (int i = 1; i < 10001; i++) {
            if (check[i]) continue;
            sb.append(i).append('\n');

            int num = i;
            while (num <= 10000) {
                check[num] = true;
                num = nextNum(num);
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static int nextNum(int num) {
        int result = num;
        int size = 0, temp = num, div = 1;
        while (temp > 0) {
            size++;
            temp /= 10;
            div *= 10;
        }
        div /= 10;

        temp = num;
        for (int i = 0; i < size; i++) {
            result += temp / div;
            temp %= div;
            div /= 10;
        }

        return result;
    }
}
