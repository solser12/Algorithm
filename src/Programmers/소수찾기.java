package Programmers;

import java.util.Arrays;
import java.util.HashSet;

public class 소수찾기 {

    public int[] number;
    public HashSet<Integer> usedNumber = new HashSet<>();
    public boolean[] primeNumber = new boolean[10000000];
    public boolean[] visited;
    public int ans = 0;

    public int solution(String numbers) {

        findPrimeNumber();
        usedNumber.add(0);

        number = new int[numbers.length()];
        visited = new boolean[numbers.length()];
        for (int i = 0; i < number.length; i++) {
            number[i] = numbers.charAt(i) - '0';
        }

        find(0, 1, 0);

        return ans;
    }

    public void findPrimeNumber() {

        Arrays.fill(primeNumber, true);

        primeNumber[0] = false;
        primeNumber[1] = false;
        for (int i = 2; i < 10000000; i++) {
            if (!primeNumber[i]) continue;
            for (int j = i + i; j < 10000000; j += i) {
                primeNumber[j] = false;
            }
        }
    }

    public void find(int depth, int index, int num) {

        if (depth == number.length) {
            if (!usedNumber.contains(num)) {
                usedNumber.add(num);

                if (primeNumber[num]) {
                    ans++;
                }
            }
            return;
        }

        for (int i = 0; i < number.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;

            find(depth + 1, index * 10, num + number[i] * index);
            find(depth + 1, index, num);
            visited[i] = false;
        }
    }
}
