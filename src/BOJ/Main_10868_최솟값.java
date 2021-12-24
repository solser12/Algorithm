package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10868_최솟값 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        SegmentTree segmentTree = new SegmentTree(arr);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(segmentTree.print(Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1))
                    .append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static class SegmentTree {

        int[] arr, tree;

        public SegmentTree(int[] arr) {
            this.arr = arr;
            int bit = 1;
            while (bit < arr.length) bit <<= 1;
            this.tree = new int[bit * 2 - 1];
            init(0, arr.length - 1, 0);
        }

        public int init(int start, int end, int node) {
            if (start == end) return tree[node] = arr[start];
            int mid = (start + end) >> 1;
            return tree[node] = Math.min(init(start, mid, node * 2 + 1), init(mid + 1, end, node * 2 + 2));
        }

        public int print(int left, int right) {
            return find(0, arr.length - 1, 0, left, right);
        }

        public int find(int start, int end, int node, int left, int right) {
            if (left > end || right < start) return Integer.MAX_VALUE;
            if (left <= start && end <= right) return tree[node];
            int mid = (start + end) >> 1;
            return Math.min(find(start, mid, node * 2 + 1, left, right),
                    find(mid + 1, end, node * 2 + 2, left, right));
        }
    }
}
