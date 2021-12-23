package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2243_사탕상자 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        CandyBox candyBox = new CandyBox();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                sb.append(candyBox.getCandy(Integer.parseInt(st.nextToken()))).append('\n');
            } else {
                candyBox.putCandy(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static class CandyBox {
        int size;
        int[] candy, tree;

        public CandyBox() {
            int len = 1 << 20;
            this.candy = new int[1000001];
            this.tree = new int[len * 2];
            this.size = 1000000;
        }

        public void putCandy(int taste, int num) {
            update(1, size, 1, taste, num);
            candy[taste] += num;
        }

        public int getCandy(int rank) {
            int result = update(1, size, 1, rank);
            candy[result]--;
            return result;
        }

        public void update(int start, int end, int node, int taste, int num) {
            if (taste < start || end < taste) return;
            tree[node] += num;
            if (start == end) return;

            int mid = (start + end) >> 1;
            update(start, mid, node * 2, taste, num);
            update(mid + 1, end, node * 2 + 1, taste, num);
        }

        public int update(int start, int end, int node, int rank) {
            tree[node]--;
            if (start == end) return start;

            int mid = (start + end) >> 1;
            if (tree[node * 2] >= rank) return update(start, mid, node * 2, rank);
            else return update(mid + 1, end, node * 2 + 1, rank - tree[node * 2]);
        }
    }
}
