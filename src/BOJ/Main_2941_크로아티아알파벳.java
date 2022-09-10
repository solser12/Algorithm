package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main_2941_크로아티아알파벳 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;

        HashSet<String> set = init();
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            if (i < input.length() - 1 && set.contains(input.substring(i, i + 2))) {
                i += 1;
                ans++;
            } else if (i < input.length() - 2 && set.contains(input.substring(i, i + 3))) {
                i += 2;
                ans++;
            } else if (input.charAt(i) != '=' && input.charAt(i) != '-') {
                ans++;
            }
        }

        System.out.println(ans);
        br.close();
    }

    public static HashSet<String> init() {
        HashSet<String> set = new HashSet<>();
        set.add("c=");
        set.add("c-");
        set.add("dz=");
        set.add("d-");
        set.add("lj");
        set.add("nj");
        set.add("s=");
        set.add("z=");
        return set;
    }
}
