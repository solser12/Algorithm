package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1298_노트북의주인을찾아서 {

    public static int N, M;
    public static int[] occupy;
    public static boolean[] visited;
    public static ArrayList<Integer>[] myNotebook;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        occupy = new int[N + 1];
        myNotebook = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            myNotebook[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            myNotebook[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            if (dfs(i)) ans++;
        }

        System.out.println(ans);
        br.close();
    }

    public static boolean dfs(int num) {
        for (int i = 0; i < myNotebook[num].size(); i++) {
            int notebookNum = myNotebook[num].get(i);
            if (visited[notebookNum]) continue;
            visited[notebookNum] = true;

            if (occupy[notebookNum] == 0 || dfs(occupy[notebookNum])) {
                occupy[notebookNum] = num;
                return true;
            }
        }
        return false;
    }
}
