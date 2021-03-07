package BOJ;

import java.io.*;
import java.util.*;

public class Main_1260_DFS와BFS {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[node + 1];

        for (int i = 0; i <= node; ++i) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        for (int i = 1; i < list.length; ++i) {
            Collections.sort(list[i]);
        }
        
        // DFS
        boolean[] visit = new boolean[node + 1];
        Stack<Integer> s = new Stack<>();
        s.push(start);
        while (!s.isEmpty()) {
            int temp = s.pop();
            if (!visit[temp]) {
                sb.append(temp).append(' ');
                visit[temp] = true;
            }
            for (int i = list[temp].size() - 1; i >= 0; --i) {
                int t = list[temp].get(i);
                if (!visit[t]) s.push(t);
            }
        }
        sb.append('\n');

        // BFS
        visit = new boolean[node + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        while(!q.isEmpty()) {
            int temp = q.poll();
            sb.append(temp).append(' ');
            for (int i = 0; i < list[temp].size(); ++i) {
                int t = list[temp].get(i);
                if (!visit[t]) {
                    visit[t] = true;
                    q.add(t);
                }
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();


    }
}
