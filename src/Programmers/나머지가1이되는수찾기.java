package Programmers;

public class 나머지가1이되는수찾기 {

    public int solution(int n) {

        boolean[] visited = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            if (n % i == 1) {
                return i;
            }

            for (long j = i; j < n; j *= i) {
                visited[(int) j] = true;
            }
        }

        return -1;
    }
}
