package Programmers.Level4;

import java.util.Arrays;
import java.util.HashMap;

public class test1 {

    public int size;
    public int[] dist;
    public HashMap<Integer, Integer> map = new HashMap<>();

    public int solution(int distance, int[] rocks, int n) {

        size = rocks.length;
        dist = new int[size + 1];
        Arrays.sort(rocks);

        dist[0] = rocks[0];
        dist[size] = distance - rocks[size - 1];
        for (int i = 1; i < size; i++) {
            dist[i] = rocks[i] - rocks[i - 1];
        }

        return binarySearch(distance, n);
    }

    public int binarySearch(int distance, int n) {
        int result = 0;
        int min = 1, max = distance;
        while (min <= max) {
            int mid = (max + min) >> 1;
            if (check(n, mid)) {
                min = mid + 1;
                result = mid;
            } else {
                max = mid - 1;
            }
        }

        return result;
    }

    public boolean check(int n, int mid) {
        int count = 0, temp = 0;
        for (int i = 0; i <= size; i++) {
            temp += dist[i];
            if (mid > temp) {
                count++;
                if (count > n) return false;
            } else {
                temp = 0;
            }
        }

        return true;
    }
}
