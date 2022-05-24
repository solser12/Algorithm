package Programmers;

public class 큰수만들기 {

    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();

        int length = number.length();
        int[] numbers = new int[length];
        for (int i = 0; i < length;  i++) {
            numbers[i] = number.charAt(i) - '0';
        }

        int start = 0, changeCnt = 0;
        while (sb.length() != length - k) {
            int maxValue = Integer.MIN_VALUE, maxIndex = -1;
            for (int i = start; i < start + Math.max(1, (k - changeCnt + 1)); i++) {
                if (maxValue < numbers[i]) {
                    maxValue = numbers[i];
                    maxIndex = i;
                }
            }

            sb.append(maxValue);
            changeCnt += maxIndex - start;
            start = maxIndex + 1;
        }

        return sb.toString();
    }
}
