package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_15668_방번호 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ans = "-1";

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= Math.min(87654, N - 1); i++) {
            int visited = check(i, 0);
            if (visited == -1 || check(N - i, visited) == -1) continue;
            ans = (N - i) + " + " + i;
            break;
        }

        System.out.println(ans);
        br.close();
    }

    public static int check(int num, int v) {
        int temp = num, visited = v;
        while (temp > 0) {
            int sticker = temp % 10;
            if ((visited & (1 << sticker)) != 0) {
                return -1;
            }
            visited |= (1 << sticker);
            temp /= 10;
        }
        return visited;
    }
}
