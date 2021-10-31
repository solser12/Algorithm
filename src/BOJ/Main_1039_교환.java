package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1039_교환 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String input = st.nextToken();
        int size = input.length();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = input.charAt(i) - '0';
        }
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(arr, K, size));

        br.close();
    }

    public static int bfs(int[] start, int K, int len) {

        Queue<int[]> q = new LinkedList<>();
        HashSet<String> oddVisited = new HashSet<>();
        HashSet<String> evenVisited = new HashSet<>();
        q.add(start);

        int time = 1;
        while (!q.isEmpty() && time <= K) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int[] poll = q.poll();
                for (int i = 0; i < len - 1; i++) {
                    for (int j = i + 1; j < len; j++) {
                        int[] temp = swap(poll, i, j);
                        if (temp[0] == 0) continue;
                        String string = toString(temp);
                        if (time % 2 == 1 && !oddVisited.contains(string)) {
                            oddVisited.add(string);
                        } else if (time % 2 == 0 && !evenVisited.contains(string)) {
                            evenVisited.add(string);
                        } else {
                            continue;
                        }
                        q.add(temp);
                    }
                }
            }
            time++;
        }

        int result = 0;
        HashSet<String> temp;
        if (K % 2 == 1) {
            temp = oddVisited;
        } else {
            temp = evenVisited;
        }

        if (temp.size() == 0) return -1;

        for (String s : temp) {
            result = Math.max(result, Integer.parseInt(s));
        }

        return result;
    }

    public static int[] swap(int[] arr, int a, int b) {
        int[] result = arr.clone();
        int temp = result[a];
        result[a] = result[b];
        result[b] = temp;
        return result;
    }

    public static String toString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return sb.toString();
    }
}
