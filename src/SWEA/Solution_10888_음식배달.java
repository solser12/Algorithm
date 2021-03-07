package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_10888_음식배달 {

    static int N;
    static int[] perm;
    static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            N = Integer.parseInt(br.readLine());
            ArrayList<Loc> house = new ArrayList<>();
            ArrayList<Loc> restaurant = new ArrayList<>();
            ans = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    if (input == 1) {
                        house.add(new Loc(i, j, 0));
                    }
                    else if (input > 1) {
                        restaurant.add(new Loc(i, j, input));
                    }
                }
            }

            int[][] cost = new int[restaurant.size()][house.size()];
            for (int i = 0; i < restaurant.size(); i++) {
                for (int j = 0; j < house.size(); j++) {
                    cost[i][j] = Math.abs(restaurant.get(i).x - house.get(j).x) + Math.abs(restaurant.get(i).y - house.get(j).y);
                }
            }

//            for (int[] i : cost) {
//                for (int j : i) {
//                    System.out.print(j + " ");
//                }
//                System.out.println();
//            }

            for (int i = restaurant.size()-1; i >= 0; i--) {
                perm = new int[restaurant.size()];
                Arrays.fill(perm, i, restaurant.size(), 1);

                do {
                    int sum = 0;
                    for (int j = 0; j < perm.length; j++) {
                        if (perm[j] == 1) {
                            sum += restaurant.get(j).c;
                        }
                    }

                    for (int j = 0; j < house.size(); j++) {
                        int temp = Integer.MAX_VALUE;
                        for (int k = 0; k < perm.length; k++) {
                            if (perm[k] == 1) {
                                temp = Math.min(temp, cost[k][j]);
                            }
                        }
                        sum += temp;
                    }
                    ans = Math.min(ans, sum);
                } while(nextPermutation());
            }
            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }
        System.out.println(sb.toString());
    }

    static boolean nextPermutation() {
        int i = perm.length - 1;
        while(i > 0 && perm[i-1] >= perm[i]) --i;
        if (i == 0) return false;

        int j = perm.length - 1;
        while(perm[i-1] >= perm[j]) --j;

        int temp = perm[i-1];
        perm[i-1] = perm[j];
        perm[j] = temp;

        j = perm.length - 1;
        while(i < j) {
            temp = perm[i];
            perm[i++] = perm[j];
            perm[j--] = temp;
        }
        return true;
    }

    static class Loc {
        int x, y, c;

        public Loc(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
}
