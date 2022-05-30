package Programmers;

import java.util.Arrays;

public class K번째수 {

    public int[] solution(int[] array, int[][] commands) {

        int[] ans = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            ans[i] = temp[commands[i][2] - 1];
        }

        return ans;
    }
}
