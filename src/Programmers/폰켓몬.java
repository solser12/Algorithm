package Programmers;

import java.util.HashSet;

public class 폰켓몬 {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return Math.min(nums.length / 2, set.size());
    }
}
