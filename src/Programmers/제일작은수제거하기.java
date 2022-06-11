package Programmers;

import java.util.LinkedHashSet;

public class 제일작은수제거하기 {

    public int[] solution(int[] arr) {

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            set.add(i);
            min = Math.min(i, min);
        }
        set.remove(min);

        int[] ans;
        if (set.size() == 0) {
            ans = new int[] {-1};
        } else {
            ans = new int[set.size()];
            int index = 0;
            for (int i : set) {
                ans[index++] = i;
            }
        }

        return ans;
    }
}
