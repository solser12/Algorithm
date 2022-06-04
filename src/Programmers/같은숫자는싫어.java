package Programmers;

import java.util.Deque;
import java.util.LinkedList;

public class 같은숫자는싫어 {

    public int[] solution(int []arr) {

        Deque<Integer> deque = new LinkedList<>();
        deque.offer(arr[0]);

        for (int i : arr) {
            if (deque.peekLast() != i) {
                deque.offerLast(i);
            }
        }

        int[] ans = new int[deque.size()];
        for (int i = 0; i  < ans.length; i++) {
            ans[i] = deque.pollFirst();
        }

        return ans;
    }
}
