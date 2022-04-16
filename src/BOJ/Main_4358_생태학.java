package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main_4358_생태학 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();

        int cnt = 0;
        String input;
        while ((input = br.readLine()) != null) {

            if (!map.containsKey(input)) {
                map.put(input, 1);
            } else {
                map.put(input, map.get(input) + 1);
            }

            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        String[] species = new String[map.size()];
        int index = 0;
        for (String s : map.keySet()) {
            species[index++] = s;
        }
        Arrays.sort(species);

        for (String s : species) {
            double calc = Math.round(((map.get(s) / (double) cnt) * 100) * 10000) / 10000.0;
            sb.append(s).append(' ').append(String.format("%.4f", calc)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }
}
