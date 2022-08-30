package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_10546_배부른마라토너 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n + n - 1; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                set.remove(name);
            } else {
                set.add(name);
            }
        }

        for (String s : set) {
            System.out.println(s);
        }
        br.close();
    }
}