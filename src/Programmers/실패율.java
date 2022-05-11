package Programmers;

import java.util.Arrays;

public class 실패율 {

    public int[] solution(int N, int[] input) {

        int[] count = new int[N+1];
        int[] sum = new int[N+1];
        Stage[] stages = new Stage[N];
        for (int i : input) {
            count[i-1]++;
        }

        sum[N] = count[N];
        for (int i = N-1; i >= 0; i--) {
            sum[i] = sum[i+1] + count[i];
        }

        for (int i = 0; i < N; i++) {
            double calc;
            if (count[i] == 0 || sum[i] == 0) calc = 0;
            else calc = count[i] / (double)sum[i];
            stages[i] = new Stage(i, calc);
        }
        Arrays.sort(stages);

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = stages[i].num;
        }

        return ans;
    }

    public class Stage implements Comparable<Stage> {
        int num;
        double calc;

        public Stage(int num, double calc) {
            this.num = num + 1;
            this.calc = calc;
        }

        @Override
        public int compareTo(Stage o) {
            int compare = Double.compare(o.calc, this.calc);
            if (compare == 0) return this.num - o.num;
            return compare;
        }
    }
}
