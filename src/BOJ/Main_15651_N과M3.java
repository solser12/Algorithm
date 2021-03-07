package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15651_N과M3 {

    static int N, M;
    static ArrayList<Integer> list = new ArrayList();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        perm(0);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void perm(int cnt) {

        if (cnt == M) {
            for (int i = 0; i < list.size(); ++i) {
                sb.append(list.get(i)).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; ++i) {
            list.add(i + 1);
            perm(cnt + 1);
            list.remove(list.size() - 1);
        }
    }
}
