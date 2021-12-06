package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2042_구간합구하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }


        SegmentTree segmentTree = new SegmentTree(arr);
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                segmentTree.change(Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken()));
            } else {
                sb.append(segmentTree.find(Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()))).append('\n');
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static class SegmentTree {
        long[] arr, tree;

        public SegmentTree(long[] arr) {
            this.arr = arr;
            int bit = 1;
            while (bit < arr.length) bit <<= 1;
            this.tree = new long[bit * 2];
            init(1, arr.length - 1, 1);
        }

        public long init(int start, int end, int node) {
            if (start == end) return tree[node] = arr[start];
            int mid = (start + end) >> 1;
            return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
        }

        public long find(int left, int right) {
            return sum(1, arr.length - 1, 1, left, right);
        }

        public long sum(int start, int end, int node, int left, int right) {
            if (left > end || right < start) return 0;
            if (left <= start && end <= right) return tree[node];
            int mid = (start + end) >> 1;
            return sum(start, mid, node * 2, left, right)
                    + sum(mid + 1, end, node * 2 + 1, left, right);
        }

        public void change(int index, long num) {
            update(1, arr.length - 1, 1, index, num - arr[index]);
            arr[index] = num;
        }

        public void update(int start, int end, int node, int index, long num) {
            if (index < start || index > end) return;
            tree[node] += num;
            if (start == end) return;
            int mid = (start + end) >> 1;
            update(start, mid, node * 2, index, num);
            update(mid + 1, end, node * 2 + 1, index, num);
        }
    }
}
