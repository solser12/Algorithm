package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10775_공항 {

    public static int[] parents;
    public static int G, P;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        make();

        int ans = 0;
        for (int i = 0; i < P; i++) {
            int num = Integer.parseInt(br.readLine());
            int parent = find(num);

            if (parent == 0) break;

            union(parent, parent - 1);
            ans++;
        }

        System.out.println(ans);
        br.close();
    }

    public static void make() {
        parents = new int[G + 1];
        for (int i = 0; i <= G; i++) {
            parents[i] = i;
        }
    }

    public static int find(int num) {
        if (parents[num] == num) return num;
        return parents[num] = find(parents[num]);
    }

    public static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        if (aParent == bParent) return;

        parents[aParent] = bParent;
    }
}
