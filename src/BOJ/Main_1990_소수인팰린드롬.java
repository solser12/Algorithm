package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1990_소수인팰린드롬 {

    public static StringBuilder sb = new StringBuilder();
    public static boolean[] primeNumber;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        primeNumber = new boolean[b + 1];

        findPrimeNumber(a, b);
        sb.append(-1).append('\n');

        System.out.println(sb);
        br.close();
    }

    public static void findPrimeNumber(int start, int end) {
        for (int i = 2; i <= end; i++) {
            if (primeNumber[i]) continue;
            if (start <= i && checkPalindrome(i)) {
                sb.append(i).append('\n');
            }
            for (int j = i + i; j <= end; j += i) {
                primeNumber[j] = true;
            }
        }
    }

    public static boolean checkPalindrome(int num) {
        int size = (int)(Math.log10(num) + 1);
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = num % 10;
            num /= 10;
        }

        int left = 0, right = size - 1;
        while (left <= right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
