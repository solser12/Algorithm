package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7578_공장 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] machines = new int[1000001];
        int N = Integer.parseInt(br.readLine());
        long ans = 0;
        SegmentTree segmentTree = new SegmentTree(N);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            machines[Integer.parseInt(st.nextToken())] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ans += segmentTree.countOverlap(machines[Integer.parseInt(st.nextToken())]);
        }

        System.out.println(ans);
        br.close();
    }

    public static class SegmentTree {
        int size;
        int[] tree;

        public SegmentTree(int N) {
            this.size = N - 1;
            int bit = 1;
            while (bit < N) bit <<= 1;
            this.tree = new int[bit * 2 - 1];
        }

        public int countOverlap(int loc) {
            int result = sum(0, size, 0, loc, size);
            update(0, size, 0, loc);
            return result;
        }

        public int sum(int start, int end, int node, int left, int right) {
            if (right < start || left > end) return 0;
            if (left <= start && end <= right) return tree[node];
            int mid = (start + end) >> 1;
            return sum(start, mid, node * 2 + 1, left, right)
                    + sum(mid + 1, end, node * 2 + 2, left, right);
        }

        public void update(int start, int end, int node, int loc) {
            if (start > loc || loc > end) return;
            tree[node]++;
            if (start == end) return;
            int mid = (start + end) >> 1;
            update(start, mid, node * 2 + 1, loc);
            update(mid + 1, end, node * 2 + 2, loc);
        }
    }
}
