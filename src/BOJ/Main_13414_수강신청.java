package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main_13414_수강신청 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashSet<String> set = new LinkedHashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        for (int i = 0; i < l; i++) {
            String num = br.readLine();
            set.remove(num);
            set.add(num);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (String s : set) {
            if (cnt == k) {
                break;
            }
            sb.append(s).append('\n');
            cnt++;
        }

        System.out.println(sb);
        br.close();
    }
}