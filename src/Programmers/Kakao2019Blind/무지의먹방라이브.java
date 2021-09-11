package Programmers.Kakao2019Blind;

import java.util.Arrays;

public class 무지의먹방라이브 {

    public static void main(String[] args) {

        int[] food = {3, 1, 2, 2, 2};
        solution(food, 100);
    }

    public static int solution(int[] food_times, long k) {

        int ans = 0;
        int len = food_times.length;
        boolean[] check = new boolean[len];
        Food[] foods = new Food[len];
        // 가능한 인덱스
        int idx = 0;
        // 걸린 시간
        long time = 1;

        for (int i = 0; i < len; i++) {
            foods[i] = new Food(food_times[i], i);
        }
        Arrays.sort(foods);

        while (len - idx <= k) {

            k -= len - idx;
            while (idx < len && foods[idx].time <= time) {
                check[foods[idx].idx] = true;
                idx++;
            }

            if (idx == len) {
                ans = -2;
                break;
            }

            time++;
        }

        if (ans != -2) {
            for (int i = 0; i < len; i++) {
                if (check[i]) continue;
                if (k == 0) {
                    ans = i;
                    break;
                }
                k--;
            }
        }

        System.out.println(ans + 1);
        return ans + 1;
    }

    public static class Food implements Comparable<Food> {
        int time, idx;

        public Food(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }

        @Override
        public int compareTo(Food o) {
            if (this.time == o.time) {
                return this.idx - o.idx;
            }
            return this.time - o.time;
        }
    }
}
