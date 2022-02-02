package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main_1181_단어정렬 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (set.contains(input)) continue;
            set.add(input);
            arr.add(input);
        }
        arr.sort((o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        });

        for (String s : arr) {
            sb.append(s).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}