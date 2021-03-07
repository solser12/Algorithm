package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1158_요세푸스 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int idx = 0;
        for (int i = 1; i <= N; i++) list.add(i);

        sb.append('<');
        while(true) {
            idx = (idx + K - 1) % list.size();
            sb.append(list.get(idx));
            list.remove(idx);
            if (!list.isEmpty()) sb.append(", ");
            else break;
        }

        sb.append('>');
        System.out.println(sb.toString());
        br.close();
    }

}
