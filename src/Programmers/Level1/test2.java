package Programmers.Level1;

public class test2 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int[] ans = new int[2];

        boolean[] arr = new boolean[46];
        for (int num : win_nums) {
            arr[num] = true;
        }

        int winCnt = 0;
        int unknown = 0;
        for (int num : lottos) {
            if (num == 0) unknown++;
            else if (arr[num]) winCnt++;
        }

        ans[0] = rank[winCnt + unknown];
        ans[1] = rank[winCnt];

        return ans;
    }
}
