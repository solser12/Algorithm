package Programmers;

import java.util.Arrays;
import java.util.HashSet;

public class 두개뽑아서더하기 {

    public int[] solution(int[] numbers) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] ans = new int[set.size()];
        int index = 0;
        for (int i : set) {
            ans[index++] = i;
        }
        Arrays.sort(ans);

        return ans;
    }
}
