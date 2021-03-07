package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
        재귀
*/

public class Solution_3289_ContactDFS {

    static ArrayList<Integer>[] list;
    static int[] visit;
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N, start;

        for (int tc = 1; tc <= 10; ++tc) {
            list = new ArrayList[101];
            visit = new int[101];
            ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            for (int i = 1; i < 101; ++i) {
                list[i] = new ArrayList();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N/2; ++i) {
                list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
            }

            Stack<Integer> stack = new Stack<>();
            stack.push(start);
            visit[start] = 1;

            while (!stack.isEmpty()) {
                int pop = stack.pop();
                int size = list[pop].size();
                for (int i = 0; i < size; ++i) {
                    int temp = list[pop].get(i);
                    if ((visit[temp] == 0) || (visit[temp] > visit[pop] + 1)) {
                        visit[temp] = visit[pop] + 1;
                        stack.push(temp);
                    }
                }
            }

            int max = 0;
            for (int i = 1; i < visit.length; ++i) {
                if (visit[i] >= max) {
                    max = visit[i];
                    ans = i;
                }
            }

            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
