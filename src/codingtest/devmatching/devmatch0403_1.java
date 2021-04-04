package codingtest.devmatching;

public class devmatch0403_1 {

    public int[] solution(int[] lottos, int[] win_nums) {

        int removeCnt = 0;
        int sameCnt = 0;
        int max, min;
        boolean[] win = new boolean[46];

        for (int num : win_nums) {
            win[num] = true;
        }

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) removeCnt++;
            else {
                if (win[lottos[i]]) sameCnt++;
            }
        }

        max = rank(removeCnt + sameCnt);
        min = rank(sameCnt);
        return new int[]{max, min};
    }

    public int rank(int cnt) {
        if (cnt > 1) {
            return 7 - cnt;
        }
        return 6;
    }
}
