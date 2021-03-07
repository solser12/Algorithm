package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {

    static int n;
    static int[] parents;
    static int[] rank;

    static void make() {
        for (int i = 1; i < n+1; i++) {
            parents[i] = i;
        }
    }
    static int find(int a) {
        if(parents[a]==a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return false;
        parents[b] = a;
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; ++tc) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            parents = new int[n+1];
            rank = new int[n+1];
            make();

            sb.append('#').append(tc).append(' ');

            for (int i = 0; i < m; ++i) {
                int ch, a, b;
                st = new StringTokenizer(br.readLine());

                ch = Integer.parseInt(st.nextToken());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                switch (ch) {
                    case 0:
                        union(a,b);
                        break;
                    case 1:
                        if (find(a) == find(b)) sb.append('1');
                        else sb.append('0');
                        break;
                }
            }

            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
