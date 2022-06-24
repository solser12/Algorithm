package Programmers;

public class 콜라츠추측 {
    public int solution(int num) {
        long temp = num;
        int cnt = 0;
        for (; cnt <= 500; cnt++) {
            if (temp == 1) {
                break;
            }
            if (temp % 2 == 0) {
                temp /= 2;
            } else {
                temp = temp * 3 + 1;
            }
        }
        return temp == 1 ? cnt : -1;
    }
}
