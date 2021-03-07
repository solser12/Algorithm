package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1100_하얀칸 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  cnt = 0;

        for (int i = 0; i < 8; i++) {
            int start = i % 2;
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (j % 2 == start && input.charAt(j) == 'F') cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
