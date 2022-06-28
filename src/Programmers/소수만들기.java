package Programmers;

public class 소수만들기 {
    public int solution(int[] nums) {
        boolean[] primeNumber = makePrimeNumber();
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (!primeNumber[sum]) {
                        primeNumber[sum] = false;
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    public boolean[] makePrimeNumber() {
        boolean[] primeNumber = new boolean[2998];
        primeNumber[0] = true;
        primeNumber[1] = true;
        for (int i = 2; i < primeNumber.length; i++) {
            if (primeNumber[i]) continue;
            for (int j = i + i; j < primeNumber.length; j += i) {
                primeNumber[j] = true;
            }
        }
        return primeNumber;
    }
}