package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_5568_카드놓기 {

    public static int n, k;
    public static int[] arr;
    public static boolean[] visited;
    public static HashSet<Integer> map = new HashSet<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dfs(0);

        System.out.println(map.size());
        br.close();
    }

    public static void dfs(int depth) {

        if (depth == k) {
            map.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            sb.append(arr[i]);
            visited[i] = true;
            dfs(depth + 1);
            sb.setLength(sb.length() - (int)(Math.log10(arr[i]) + 1));
            visited[i] = false;
        }
    }
}