package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2635_수이어가기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int cnt = 2;
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(N);
            temp.add(i);

            while (temp.get(temp.size() - 1) <= temp.get(temp.size() - 2)) {
                temp.add(temp.get(temp.size() - 2) - temp.get(temp.size() - 1));
                cnt++;
            }

            if (cnt > ans) {
                ans = cnt;
                list = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans).append('\n');
        for (int i : list) {
            sb.append(i).append(' ');
        }
        sb.setLength(sb.length() - 1);

        System.out.println(sb);
        br.close();
    }
}
