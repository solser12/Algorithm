package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_로또 {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] arr;
    static int k;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()).charAt(0) != '0') {
            StringTokenizer st = new StringTokenizer(input);
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, "");
            sb.append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static void dfs(int depth, int start, String s) {

        if (depth == 6) {
            sb.append(s).append('\n');
            return;
        }

        for (int i = start; i < k; i++) {
            StringBuilder temp = new StringBuilder(s);
            if (visited[i]) continue;
            visited[i] = true;
            temp.append(arr[i]).append(' ');
            dfs(depth + 1, i + 1, temp.toString());
            visited[i] = false;
        }
    }
}
