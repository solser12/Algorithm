package Programmers;

public class 부족한금액계산하기 {

    public long solution(int price, int money, int count) {
        long ans = ((count * (price + ((long) price * count))) / 2) - money;
        return ans <= 0 ? 0 : ans;
    }
}
