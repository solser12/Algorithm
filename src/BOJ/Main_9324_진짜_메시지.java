package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9324_진짜_메시지 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            Program program = new Program();
            boolean isFake = false;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (!program.check(c)) {
                    isFake = true;
                    break;
                }
            }
            sb.append(isFake || !program.lastCheck() ? "FAKE\n" : "OK\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static class Program {

        int[] cnt = new int[26];
        int lastNum = -1;

        public boolean check(char c) {
            int num = c - 'A';
            if (cnt[num] == 3) {
                if (num == lastNum) {
                    cnt[num] = 0;
                    return true;
                }
                return false;
            }
            cnt[num]++;
            lastNum = num;
            return true;
        }

        public boolean lastCheck() {
            for (int i : cnt) {
                if (i == 3) {
                    return false;
                }
            }
            return true;
        }
    }
}
