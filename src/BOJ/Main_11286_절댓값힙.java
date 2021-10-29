package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11286_절댓값힙 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Heap heap = new Heap(N);

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                sb.append(heap.poll()).append('\n');
            } else {
                heap.add(num);
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static class Heap {
        Node[] arr;
        int size;

        public Heap(int len) {
            this.arr = new Node[len];
            this.size = 0;
        }

        public void add(int num) {
            arr[size] = new Node(num, Math.abs(num));
            addHeapify(size++);
        }

        public int poll() {
            if (size == 0) return 0;
            Node result = arr[0];
            arr[0] = arr[--size];
            pollHeapfiy(0);

            return result.val;
        }

        public void pollHeapfiy(int index) {

            int p = index;
            int l = (index << 1) + 1;
            int r = (index << 1) + 2;

            if (l < size && arr[l].compareTo(arr[p]) < 0) {
                p = l;
            }
            if (r < size && arr[r].compareTo(arr[p]) < 0) {
                p = r;
            }

            if (p != index) {
                swap(index, p);
                pollHeapfiy(p);
            }
        }

        public void addHeapify(int index) {
            int parent = (index - 1) >> 1;
            if (parent < 0) return;

            if (arr[index].compareTo(arr[parent]) < 0) {
                swap(index, parent);
                addHeapify(parent);
            }
        }

        public void swap(int a, int b) {
            Node temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    public static class Node implements Comparable<Node> {
        int val, abs;

        public Node(int val, int abs) {
            this.val = val;
            this.abs = abs;
        }

        @Override
        public int compareTo(Node o) {
            if (this.abs == o.abs) {
                return Integer.compare(this.val, o.val);
            }
            return Integer.compare(this.abs, o.abs);
        }
    }
}
