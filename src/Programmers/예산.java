package Programmers;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int ans = 0;
        for (int i : d) {
            if (budget < i) {
                break;
            }
            budget -= i;
            ans++;
        }
        return ans;
    }
}
