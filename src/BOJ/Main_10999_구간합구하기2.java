package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10999_구간합구하기2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SegmentTree segmentTree = new SegmentTree(arr);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                int left = Integer.parseInt(st.nextToken()) - 1;
                int right = Integer.parseInt(st.nextToken()) - 1;
                long num = Long.parseLong(st.nextToken());
                segmentTree.change(left, right, num);
            } else {
                sb.append(segmentTree.find(Integer.parseInt(st.nextToken()) - 1,
                        Integer.parseInt(st.nextToken()) - 1)).append('\n');
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static class SegmentTree {
        int size;
        long[] tree, lazy;

        public SegmentTree(long[] arr) {
            this.size = arr.length - 1;
            int bit = 1;
            while (bit < arr.length) bit <<= 1;
            this.tree = new long[bit * 2 - 1];
            this.lazy = new long[bit * 2 - 1];
            init(arr, 0, size, 0);
        }

        public long init(long[]arr, int start, int end, int node) {
            if (start == end) return tree[node] = arr[start];
            int mid = (start + end) >> 1;
            return tree[node] = init(arr, start, mid, node * 2 + 1)
                    + init(arr, mid + 1, end, node * 2 + 2);
        }

        public void change(int left, int right, long num) {
            update(0, size, 0, left, right, num);
        }

        public void update(int start, int end, int node, int left, int right, long num) {
            lazyUpdate(start, end, node);
            if (left > end || right < start) return;

            if (left <= start && end <= right) {
                lazy[node] += num;
                lazyUpdate(start, end, node);
                return;
            }

            int mid = (start + end) >> 1;
            update(start, mid, node * 2 + 1, left, right, num);
            update(mid + 1, end, node * 2 + 2, left, right, num);

            tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2];
        }

        public void lazyUpdate(int start, int end, int node) {
            if (lazy[node] == 0) return;

            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[node * 2 + 1] += lazy[node];
                lazy[node * 2 + 2] += lazy[node];
            }

            lazy[node] = 0;
        }

        public long find(int left, int right) {
            return sum(0, size, 0, left, right);
        }

        public long sum(int start, int end, int node, int left, int right) {
            lazyUpdate(start, end, node);
            if (left > end || right < start) return 0;
            if (left <= start && end <= right) return tree[node];
            int mid = (start + end) >> 1;
            return sum(start, mid, node * 2 + 1, left, right)
                    + sum(mid + 1, end, node * 2 + 2, left, right);
        }
    }
}
