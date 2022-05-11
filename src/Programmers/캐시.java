package Programmers.kakao2018Blind;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class 캐시 {

    public static void main(String[] args) {

        int c = 2;
        String[] s = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        System.out.println(solution(c, s));
    }

    public static int solution(int cacheSize, String[] cities) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        Deque<Integer> dq = new LinkedList<>();
        Stack<Integer> s = new Stack<>();

        boolean[] check = new boolean[100000];
        int time = 0;

        for (String city : cities) {
            String small = change(city);
            if (!hashMap.containsKey(small)) {
                hashMap.put(small, hashMap.size());
            }

            int num = hashMap.get(small);
            if (check[num]) {
                while (dq.peek() != num) {
                    s.push(dq.poll());
                }
                dq.offer(dq.poll());

                while (!s.isEmpty()) {
                    dq.offerFirst(s.pop());
                }

                time++;
            } else {
                if (cacheSize != 0) {
                    check[num] = true;
                    if (dq.size() == cacheSize) {
                        check[dq.poll()] = false;
                    }
                    dq.offer(num);
                }
                time += 5;
            }
        }

        return time;
    }

    public static String change(String city) {
        char[] arr = city.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if ('A' <= arr[i] && arr[i] <= 'Z') {
                arr[i] += 32;
            }
        }

        return String.valueOf(arr);
    }
}
