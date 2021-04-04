package codingtest.kakao;

import java.util.Arrays;

public class start {

    public static void main(String[] args) {

        Kakao0403_3 a = new Kakao0403_3();

//        int n = 6;
//        int[] passenger = {1,1,1,1,1,1};
//        int[][] train = {{1, 2}, {1, 3}, {1,4}, {3, 5}, {3, 6}};

//        int n = 4;
//        int[] passenger = {2, 1, 2, 2};
//        int[][] train = {{1, 2}, {1, 3}, {2,4}};

        int n = 10;
        int[] passenger = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[][] train = {{1, 2}, {1, 3}, {1,4}, {1, 5}, {1, 6}, {1, 7}, {1,8}};

        System.out.println(Arrays.toString(a.solution(n, passenger, train)));
    }
}
