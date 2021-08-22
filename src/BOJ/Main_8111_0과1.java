package BOJ;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main_8111_0과1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Data> q = new LinkedList<>();
        boolean[] visited;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            q.clear();
            int num = Integer.parseInt(br.readLine());
            visited = new boolean[num + 1];
            visited[num] = true;
            boolean isFind = false;

            for (int i = 1; i < 10; i++) {
                int calc = num * i;
                if (calc % 10 == 1) {
                    q.add(new Data(calc / 10, "", "1"));
                    visited[calc / 10] = true;
                } else if (calc % 10 == 0) {
                    q.add(new Data(calc / 10, "", "0"));
                    visited[calc / 10] = true;
                }
            }

            while (!q.isEmpty()) {
                Data data = q.poll();

                if (data.sb.length() > 100) continue;
                if (data.num == num) continue;

                if (data.num == 0) {
                    bw.write(data.sb + "\n");
                    isFind = true;
                    break;
                }
                for (int i = 0; i < 10; i++) {
                    int calc = data.num + (num * i);
                    int div = calc / 10;
                    if (!visited[div]) {
                        if (calc % 10 == 1) {
                            q.add(new Data(calc / 10, data.sb.toString(), "1"));
                            visited[div] = true;
                        } else if (calc % 10 == 0) {
                            q.add(new Data(calc / 10, data.sb.toString(), "0"));
                            visited[div] = true;
                        }
                    }
                }
            }

            if (!isFind) {
                bw.write("BRAK\n");
            }
        }

        bw.close();
        br.close();
    }

    public static class Data {

        int num;
        StringBuilder sb;

        public Data(int num, String s, String add) {
            this.num = num;
            sb = new StringBuilder(s);
            sb.insert(0, add);
        }
    }
}
