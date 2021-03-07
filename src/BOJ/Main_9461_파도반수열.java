package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_9461_파도반수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Long> list = new ArrayList<>();

        list.add((long) 1);
        list.add((long) 1);
        list.add((long) 1);
        list.add((long) 2);
        list.add((long) 2);

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            if (N > list.size()) {
                for (int i = list.size(); i < N; i++) {
                    list.add(list.get(list.size()-1)+list.get(list.size()-5));
                }
            }
            sb.append(list.get(N-1)).append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }
}
