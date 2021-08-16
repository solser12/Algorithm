package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class Main_4256_트리 {

    static int n, idx;
    static int[] preorder, inorder, index;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            preorder = new int[n];
            inorder = new int[n];
            index = new int[n + 1];
            idx = 1;
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                preorder[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                inorder[i] = num;
                index[num] = i;
            }

            find(preorder[0], -1, preorder.length);
            bw.write("\n");
        }

        bw.close();
        br.close();
    }

    public static void find(int num, int left, int right) throws IOException {

        if (idx < n) {
            int node = preorder[idx];

            if (left < index[node] && index[node] < index[num]) {
                idx++;
                find(node, left, index[num]);
            }
        }

        if (idx < n) {
            int node = preorder[idx];

            if (index[num] < index[node] && index[node] < right) {
                idx++;
                find(node, index[num], right);
            }
        }

        bw.write(num + " ");
    }
}
