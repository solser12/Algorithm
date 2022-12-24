package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10798_세로읽기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] toy = new char[5][15];

        for (int i = 0; i < 5; i++) {
            Arrays.fill(toy[i], ' ');
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                toy[i][j] = input.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (toy[j][i] != ' ') {
                    sb.append(toy[j][i]);
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
