package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {

    static int[] gy = new int[9];
    static int[] iy = new int[9];
    static boolean[] isSelected;
    static int[] numbers;
    static int win, lose, gscore, iscore;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            numbers = new int[9];
            isSelected = new boolean[9];
            boolean[] temp = new boolean[18];
            int loc = 0; win = 0; lose = 0;
            gscore = 0; iscore = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 9; i++) {
                gy[i] = Integer.parseInt(st.nextToken());
                temp[gy[i]-1] = true;
            }

            for (int i = 0; i < 18; i++) {
                if (!temp[i]) iy[loc++] = i+1;
            }

            perm(0);

            sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static void perm(int cnt) {
        if (cnt == 9) {
            for (int i = 0; i < 9; i++) {
                if (numbers[i] > gy[i]) {
                    iscore += numbers[i] + gy[i];
                }
                else if(numbers[i] < gy[i]) {
                    gscore += numbers[i] + gy[i];
                }
            }

            if (gscore > iscore) win++;
            else if (gscore < iscore) lose++;
            gscore = 0; iscore = 0;
        }
        else {
            for (int i = 0; i < 9; i++) {
                if (isSelected[i] == false) {
                    numbers[cnt] = iy[i];
                    isSelected[i] = true;
                    perm(cnt+1);
                    isSelected[i] = false;
                }
            }
        }
    }
}
