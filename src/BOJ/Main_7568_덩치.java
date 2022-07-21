package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7568_덩치 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Human[] humans = new Human[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            humans[i] = new Human(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for (int j = 0; j < i; j++) {
                humans[i].compare(humans[j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Human human : humans) {
            sb.append(human.rank).append(' ');
        }

        System.out.println(sb);
        br.close();
    }

    public static class Human {

        int height, weight, rank;

        public Human(int height, int weight) {
            this.height = height;
            this.weight = weight;
            this.rank = 1;
        }

        public void compare(Human o) {
            int h = Integer.compare(this.height, o.height);
            int w = Integer.compare(this.weight, o.weight);
            if (h == -1 && w == -1) {
                this.rank++;
            } else if (h == 1 && w == 1) {
                o.rank++;
            }
        }
    }
}
