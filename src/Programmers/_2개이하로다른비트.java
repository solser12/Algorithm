package Programmers;

public class _2개이하로다른비트 {

    public long[] solution(long[] numbers) {

        final long MAX_LONG = 1000000000000000L;

        long[] ans = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {

            long result = 0;

            for (long bit = 1; bit <= MAX_LONG + 1; bit <<= 1) {
                long comparer = numbers[i] ^ bit;
                if (numbers[i] < comparer) {
                    result = comparer;
                    break;
                }
            }

            for (long m = 1; m <= MAX_LONG + 1; m <<= 1) {
                for (long n = m << 1; n <= MAX_LONG + 1; n <<= 1) {
                    long comparer = (numbers[i] ^ m) ^ n;
                    if (numbers[i] < comparer) {
                        result = Math.min(result, comparer);
                        break;
                    }
                }
            }

            ans[i] = result;
        }

        return ans;
    }
}
