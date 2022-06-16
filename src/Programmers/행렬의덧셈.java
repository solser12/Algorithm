package Programmers;

public class 행렬의덧셈 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] ans = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return ans;
    }
}
