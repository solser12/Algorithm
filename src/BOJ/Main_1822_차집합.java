package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1822_차집합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int na = Integer.parseInt(st.nextToken());
        int nb = Integer.parseInt(st.nextToken());

        HashSet<Integer> aSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < na; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nb; i++) {
            int num = Integer.parseInt(st.nextToken());
            aSet.remove(num);
        }

        int[] ans = new int[aSet.size()];
        int index = 0;
        for (int i : aSet) {
            ans[index++] = i;
        }
        Arrays.sort(ans);

        StringBuilder sb = new StringBuilder();
        sb.append(ans.length).append('\n');
        for (int i : ans) {
            sb.append(i).append(' ');
        }
        sb.setLength(sb.length() - 1);

        System.out.print(sb);
        br.close();
    }
}