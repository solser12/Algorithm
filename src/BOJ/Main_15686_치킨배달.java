package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {

    static int N, M;
    static ArrayList<Building> house = new ArrayList<>();
    static ArrayList<Building> chicken = new ArrayList<>();
    static ArrayList<Building> choice = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) house.add(new Building(i, j));
                else if (temp == 2) chicken.add(new Building(i, j));
            }
        }

        comb(0 , 0);

        System.out.println(ans);
        br.close();
    }

    static void comb(int cnt, int target) {
        if (cnt == M) {
            int sum = 0;
            for (Building h : house) {
                int min = Integer.MAX_VALUE;
                for (Building c : choice) {
                    int temp = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);
                    min = temp < min ? temp : min;
                }
                sum += min;
            }
            ans = sum < ans ? sum : ans;
            return;
        }

        if (target >= chicken.size()) return;

        choice.add(chicken.get(target));
        comb(cnt + 1, target + 1);
        choice.remove(choice.size() - 1);
        comb(cnt , target + 1);
    }

    static class Building {
        int x, y;

        Building(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
