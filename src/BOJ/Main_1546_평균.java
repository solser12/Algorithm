package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1546_평균 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] score = new int[N];
        int maxScore = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            maxScore = Math.max(maxScore, score[i]);
        }

        double sum = 0;
        for (int i : score) {
            sum += (i / (double)maxScore) * 100;
        }

        System.out.println(sum / N);
        br.close();
    }
}
