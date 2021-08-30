package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19637_IF문좀대신써줘 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Title[] titles = new Title[N];
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            titles[i] = new Title(name, power);
        }

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            int left = 0, right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (num <= titles[mid].power) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            sb.append(titles[right+1].name).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static class Title {
        String name;
        int power;

        public Title(String name, int power) {
            this.name = name;
            this.power = power;
        }
    }
}
