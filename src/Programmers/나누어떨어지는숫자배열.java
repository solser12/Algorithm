package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {

        Arrays.sort(arr);
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i : arr) {
            if (i % divisor == 0) {
                temp.add(i);
            }
        }

        int[] ans = new int[Math.max(temp.size(), 1)];
        ans[0] = -1;
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }

        return ans;
    }
}
