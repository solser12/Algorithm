package Programmers.Kakao2018Blind;

public class 비밀지도 {

    public static void main(String[] args) {

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        solution(n, arr1, arr2);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {

        String[] ans = new String[n];

        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = arr1[i];
            map[i] |= arr2[i];
        }

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int idx = 1 << n;
            for (int j = n - 1; j >= 0; j--) {
                idx >>= 1;
                if ((map[i] & idx) > 0) sb.append('#');
                else sb.append(' ');
            }
            System.out.println(sb);
            ans[i] = sb.toString();
        }

        return ans;
    }

}
