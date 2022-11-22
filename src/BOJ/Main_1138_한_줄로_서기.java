package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1138_한_줄로_서기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> index = new ArrayList<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            index.add(i);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            ans[index.get(num)] = i;
            index.remove(num);
        }


        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i).append(' ');
        }
        sb.setLength(sb.length() - 1);

        System.out.println(sb);
        br.close();
    }
}