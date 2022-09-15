package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2251_물통 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aMax = Integer.parseInt(st.nextToken());
        int bMax = Integer.parseInt(st.nextToken());
        int cMax = Integer.parseInt(st.nextToken());

        Queue<Bottle> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        q.offer(new Bottle(0 , 0, cMax));
        visited.add(cMax);
        while (!q.isEmpty()) {
            Bottle bottle = q.poll();
            if (bottle.a == 0) {
                set.add(bottle.c);
            }

            Bottle temp;
            int num;
            // a > b
            temp = fill(bottle.a, bottle.b, bottle.c, bMax);
            num = stateToInteger(temp.a, temp.b, temp.c);
            if (!visited.contains(num)) {
                visited.add(num);
                q.offer(new Bottle(temp.a, temp.b, temp.c));
            }

            // a > c
            temp = fill(bottle.a, bottle.c, bottle.b, cMax);
            num = stateToInteger(temp.a, temp.c, temp.b);
            if (!visited.contains(num)) {
                visited.add(num);
                q.offer(new Bottle(temp.a, temp.c, temp.b));
            }

            // b > a
            temp = fill(bottle.b, bottle.a, bottle.c, aMax);
            num = stateToInteger(temp.b, temp.a, temp.c);
            if (!visited.contains(num)) {
                visited.add(num);
                q.offer(new Bottle(temp.b, temp.a, temp.c));
            }

            // b > c
            temp = fill(bottle.b, bottle.c, bottle.a, cMax);
            num = stateToInteger(temp.c, temp.a, temp.b);
            if (!visited.contains(num)) {
                visited.add(num);
                q.offer(new Bottle(temp.c, temp.a, temp.b));
            }

            // c > a
            temp = fill(bottle.c, bottle.a, bottle.b, aMax);
            num = stateToInteger(temp.b, temp.c, temp.a);
            if (!visited.contains(num)) {
                visited.add(num);
                q.offer(new Bottle(temp.b, temp.c, temp.a));
            }

            // c > b
            temp = fill(bottle.c, bottle.b, bottle.a, bMax);
            num = stateToInteger(temp.c, temp.b, temp.a);
            if (!visited.contains(num)) {
                visited.add(num);
                q.offer(new Bottle(temp.c, temp.b, temp.a));
            }
        }

        int[] ans = new int[set.size()];
        int index = 0;
        for (int i : set) {
            ans[index++] = i;
        }
        Arrays.sort(ans);

        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);
        br.close();
    }

    public static Bottle fill(int a, int b, int c, int bMax) {
        return new Bottle(Math.max(0 , (a - (bMax - b))), Math.min(bMax, b + a), c);
    }

    public static int stateToInteger(int a, int b, int c) {
        return (a * 1000000) + (b * 1000) + c;
    }

    public static class Bottle {
        int a, b, c;

        public Bottle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
