package SWEA;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리_Kruskal {

    static int[] list;
    static int[] rank;
    static Edge[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; ++tc) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            make(V);
            arr = new Edge[E];

            for (int i = 0; i < E; ++i) {
                st = new StringTokenizer(br.readLine());
                arr[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(arr);

            int cnt = 0;
            long sum = 0;

            for (Edge i : arr) {
                if (union(i.node[0] - 1, i.node[1] - 1)) {
                    sum += i.v;
                    if (++cnt == V - 1) break;
                }
            }

            sb.append('#').append(tc).append(' ').append(sum).append('\n');
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static void make(int V) {
        list = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; ++i) {
            list[i] = i;
        }
    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return false;

        if (rank[a] < rank[b]) {
            list[a] = b;
        }
        else {
            list[b] = a;
            if (rank[a] == rank[b]) rank[a]++;
        }
        return true;
    }

    public static int find(int a) {
        if(list[a] == a) return a;
        return list[a] = find(list[a]);
    }

    public static class Edge implements Comparable <Edge> {
        int[] node = new int[2];
        int v;

        Edge (int a, int b, int v) {
            node[0] = a;
            node[1] = b;
            this.v = v;
        }

        @Override
        public int compareTo (Edge o) {
            return Integer.compare(this.v, o.v);
        }
    }
}
