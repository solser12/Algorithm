package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1991_트리순회 {

    static int[][] tree = new int[26][2];
    static int root;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'A';
            int b = st.nextToken().charAt(0) - 'A';
            int c = st.nextToken().charAt(0) - 'A';
            if (b < 0 || b >= 26) b = -1;
            if (c < 0 || c >= 26) c = -1;

            if (i == 0) {
                root = a;
                tree[root][0] = b;
                tree[root][1] = c;

            } else {
                tree[a][0] = b;
                tree[a][1] = c;
            }

        }
        preorderT(root);
        sb.append('\n');
        inorderT(root);
        sb.append('\n');
        postorderT(root);
        sb.append('\n');

        System.out.println(sb.toString());
        br.close();
    }

    static void preorderT(int r) {
        sb.append((char)(r + 'A'));
        if (tree[r][0] != -1) preorderT(tree[r][0]);
        if (tree[r][1] != -1) preorderT(tree[r][1]);
    }

    static void inorderT(int r) {
        if (tree[r][0] != -1) inorderT(tree[r][0]);
        sb.append((char)(r + 'A'));
        if (tree[r][1] != -1) inorderT(tree[r][1]);
    }

    static void postorderT(int r) {
        if (tree[r][0] != -1) postorderT(tree[r][0]);
        if (tree[r][1] != -1) postorderT(tree[r][1]);
        sb.append((char)(r + 'A'));
    }
}
