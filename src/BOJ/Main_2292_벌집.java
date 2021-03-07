package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2292_벌집 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> level = new ArrayList<>();
        int idx = 0;

        // 6(n-1) + f(n-1)
        // 이동거리는 레벨에 따라 정해짐
        level.add(1);	// level 0

        while(true) {
            int num = level.get(level.size()-1) + 6 * idx++;
            if (num >= N) break;
            level.add(num);
        }

        System.out.println(idx);
        br.close();
    }
}
