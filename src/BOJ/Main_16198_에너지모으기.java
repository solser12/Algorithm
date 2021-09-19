package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_16198_에너지모으기 {

    static int N, ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> energy = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            energy.add(Integer.parseInt(st.nextToken()));
        }

        check(0, energy);

        System.out.println(ans);
        br.close();
    }

    public static void check(int sum, ArrayList<Integer> energy) {

        if (energy.size() < 3) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 1; i < energy.size() - 1; i++) {
            ArrayList<Integer> temp = (ArrayList<Integer>) energy.clone();
            int add = temp.get(i-1) * temp.get(i+1);
            temp.remove(i);
            check(sum + add, temp);
        }
    }
}
