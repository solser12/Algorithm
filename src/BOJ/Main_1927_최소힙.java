package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1927_최소힙 {

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
        int index;

        public Heap(int N) {
            arr = new int[N];
            index = 0;
        }

        public void add(int num) {
            arr[index] = num;
            addHeapify(index);
            index++;
        }

        public int poll() {
            if (index == 0 ) return 0;
            int result = arr[0];
            arr[0] = arr[--index];
            pollHeapify(0);
            return result;
        }

        public void pollHeapify(int idx) {
            int p = idx;
            int l = (idx << 1) + 1;
            int r = (idx << 1) + 2;

            if (l < index && arr[l] < arr[p]) {
                p = l;
            }

            if (r < index && arr[r] < arr[p]) {
                p = r;
            }

            if (p != idx) {
                swap(idx, p);
                pollHeapify(p);
            }
        }

        public void addHeapify(int idx) {

            int temp = (idx - 1) >> 1;
            if (temp < 0) return;

            if (arr[temp] > arr[idx]) {
                swap(idx, temp);
                addHeapify(temp);
            }
        }

        public void swap(int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}
