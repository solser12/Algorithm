package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_14729_칠무해 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] students = new double[N];
        for (int i = 0; i < N; i++) {
            students[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(students);

        for (int i = 0; i < 7; i++) {
            System.out.printf("%.3f\n", students[i]);
        }

        br.close();
    }
}
