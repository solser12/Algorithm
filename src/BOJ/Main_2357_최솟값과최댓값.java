package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2357_최솟값과최댓값 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree segmentTree = new SegmentTree(arr);
        StringBuilder sb =  new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(segmentTree.find(Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static class SegmentTree {

        int size;
        int[] maxTree, minTree;

        public SegmentTree(int[] arr) {
            this.size = arr.length - 1;
            int bit = 1;
            while (bit < size) bit <<= 1;
            maxTree = new int[bit * 2 - 1];
            minTree = new int[bit * 2 - 1];
            maxInit(arr, 0, size, 0);
            minInit(arr, 0, size, 0);
        }

        public int maxInit(int[] arr, int start, int end, int node) {
            if (start == end) return maxTree[node] = arr[start];
            int mid = (start + end) >> 1;
            return maxTree[node] = Math.max(maxInit(arr, start, mid, node * 2 + 1),
                    maxInit(arr, mid + 1, end, node * 2 + 2));
        }

        public int minInit(int[] arr, int start, int end, int node) {
            if (start == end) return minTree[node] = arr[start];
            int mid = (start + end) >> 1;
            return minTree[node] = Math.min(minInit(arr, start, mid, node * 2 + 1),
                    minInit(arr, mid + 1, end, node * 2 + 2));
        }

        public String find(int left, int right) {
            return findMin(0, size, 0, left, right) + " " + findMax(0, size, 0, left, right);
        }

        public int findMax(int start, int end, int node, int left, int right) {
            if (left > end || right < start) return Integer.MIN_VALUE;
            if (left <= start && end <= right) return maxTree[node];
            int mid = (start + end) >> 1;
            return Math.max(findMax(start, mid, node * 2 + 1, left, right),
                    findMax(mid + 1, end, node * 2 + 2, left, right));
        }

        public int findMin(int start, int end, int node, int left, int right) {
            if (left > end || right < start) return Integer.MAX_VALUE;
            if (left <= start && end <= right) return minTree[node];
            int mid = (start + end) >> 1;
            return Math.min(findMin(start, mid, node * 2 + 1, left, right),
                    findMin(mid + 1, end, node * 2 + 2, left, right));
        }
    }
}
