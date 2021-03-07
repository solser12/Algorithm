package SWEA;

import java.io.*;
import java.util.*;
import java.lang.StringBuilder;

public class Solution_3289_ContactBFS {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        ArrayList<Integer>[] list;
        boolean[] visit;
        int ans, max;
        int N, start;

        for (int tc = 1; tc <= 1; ++tc) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            list = new ArrayList[101];
            visit = new boolean[101];
            ans = start;
            max = -1;

            for (int i = 1; i < 101; ++i) {
                list[i] = new ArrayList();
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N/2; ++i) {
                list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
            }

            int cnt = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            visit[start] = true;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; ++i) {
                    int data = queue.poll();
                    System.out.println(data + " " + cnt);
                    int r = list[data].size();
                    for (int j = 0; j < r; ++j) {
                        int temp = list[data].get(j);
                        if (visit[temp]) continue;
                        queue.add(temp);
                        visit[temp] = true;
                    }
                    if (cnt == max && ans < data) {
                        ans = data;
                    }
                    else if (cnt > max) {
                        max = cnt;
                        ans = data;
                    }
                }
                cnt++;
            }

            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
