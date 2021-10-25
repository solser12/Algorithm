package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11279_최대힙 {

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
        int[] arr;
        int size;

        public Heap(int N) {
            this.arr = new int[N];
            size = 0;
        }

        public void add(int num) {
            arr[size] = num;
            addHeapfiy(size);
            size++;
        }

        public void addHeapfiy(int index) {
            int parent = (index - 1) >> 1;

            if (parent < 0) return;

            if (arr[parent] < arr[index]) {
                swap(parent, index);
                addHeapfiy(parent);
            }
        }

        public int poll() {
            if (size == 0) return 0;
            int result = arr[0];
            arr[0] = arr[--size];
            pollHeapfiy(0);
            return result;
        }

        public void pollHeapfiy(int parent) {
            int p = parent;
            int l = (parent << 1) + 1;
            int r = (parent << 1) + 2;

            if (l < size && arr[p] < arr[l]) {
                p = l;
            }

            if (r < size && arr[p] < arr[r]) {
                p = r;
            }

            if (p != parent) {
                swap(p, parent);
                pollHeapfiy(p);
            }
        }

        public void swap(int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
