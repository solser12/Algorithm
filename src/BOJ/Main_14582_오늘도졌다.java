package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14582_오늘도졌다 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer a = new StringTokenizer(br.readLine());
        StringTokenizer b = new StringTokenizer(br.readLine());
        int aScore = 0;
        int bScore = 0;
        boolean aWin = false;
        boolean bWin = false;
        for (int i = 0; i < 9; i++) {

            aScore += Integer.parseInt(a.nextToken());
            if (aScore > bScore) {
                aWin = true;
            }

            bScore += Integer.parseInt(b.nextToken());
            if (aScore < bScore && aWin) {
                bWin = true;
            }
        }

        System.out.println(bWin ? "Yes" : "No");
        br.close();
    }
}
