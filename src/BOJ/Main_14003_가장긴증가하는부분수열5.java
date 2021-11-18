package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_14003_가장긴증가하는부분수열5 {

    public static int[] arr, save, index;
    public static int arrIndex = 0, pointer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        save = new int[N];
        index = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        save[0] = num;
        arr[arrIndex] = num;
        index[arrIndex++] = 0;

        for (int i = 1; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            insert(num);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pointer + 1).append('\n');

        Stack<Integer> stack = new Stack<>();
        int idx = pointer;
        for (int i = N - 1; i >= 0; i--) {
            if (index[i] == idx) {
                stack.push(arr[i]);
                idx--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb);
        br.close();
    }

    public static void insert(int num) {
        arr[arrIndex] = num;
        if (save[pointer] > num) {
            int i = binarySearch(num);
            save[i] = num;
            index[arrIndex] = i;
        } else if (save[pointer] < num) {
            save[++pointer] = num;
            index[arrIndex] = pointer;
        } else {
            index[arrIndex] = pointer;
        }
        arrIndex++;
    }

    public static int binarySearch(int num) {
        int left = -1, right = pointer;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;

            if (save[mid] < num) left = mid;
            else right = mid;
        }

        return right;
    }
}
