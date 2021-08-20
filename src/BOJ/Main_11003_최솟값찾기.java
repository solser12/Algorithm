package BOJ;

import java.io.*;
import java.util.*;

public class Main_11003_최솟값찾기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Num> dq = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {

            int num = Integer.parseInt(st.nextToken());
            while (!dq.isEmpty() && dq.peekLast().num >= num) {
                dq.removeLast();
            }

            if (!dq.isEmpty() && dq.peek().idx + L <= i) {
                dq.remove();
            }

            dq.add(new Num(num, i));

            bw.write(dq.peek().num + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static class Num {
        int num, idx;

        public Num(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
