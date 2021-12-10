package Programmers.Level1;

public class test1 {
    public String solution(int a, int b) {
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int cnt = b;
        for (int i = 1; i <= 12; i++) {
            if (i == a) break;
            cnt += month[i];
        }

        return day[cnt % 7];
    }
}
