package algorithm;

public class SegmentTree {

    public static void main(String[] args) {

    }

    public static class Tree {
        long[] arr, tree;

        public Tree(long[] arr) {
            this.arr = arr;
            int bit = 1;
            while (bit < arr.length) bit <<= 1;
            this.tree = new long[bit * 2 - 1];
            init(0, arr.length - 1, 0);
        }

        public long init(int start, int end, int node) {
            if (start == end) return tree[node] = arr[start];
            int mid = (start + end) >> 1;
            return tree[node] = init(start, mid, node * 2 + 1) + init(mid + 1, end, node * 2 + 2);
        }

        public long find(int left, int right) {
            return sum(0, arr.length - 1, 0, left, right);
        }

        public long sum(int start, int end, int node, int left, int right) {
            if (left > end || right < start) return 0;
            if (left <= start && end <= right) return tree[node];
            int mid = (start + end) >> 1;
            return sum(start, mid, node * 2 + 1, left, right)
                    + sum(mid + 1, end, node * 2 + 2, left, right);
        }

        public void change(int index, long num) {
            update(0, arr.length - 1, 0, index, num - arr[index]);
            arr[index] = num;
        }

        public void update(int start, int end, int node, int index, long num) {
            if (index < start || index > end) return;
            tree[node] += num;
            if (start == end) return;
            int mid = (start + end) >> 1;
            update(start, mid, node * 2 + 1, index, num);
            update(mid + 1, end, node * 2 + 2, index, num);
        }
    }
}
