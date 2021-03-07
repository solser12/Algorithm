package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {

    static Gear[] gears = new Gear[5];
    static boolean[] check = new boolean[3];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i < 5; i++) {
            gears[i] = new Gear();
            String input = br.readLine();
            for (int j = 1; j <= 8; j++) {
                gears[i].addNS(j, input.charAt(j-1) - '0');
            }
        }
        setConnect();

        int cnt = Integer.parseInt(br.readLine());
        for (int c = 0; c < cnt; c++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int way = Integer.parseInt(st.nextToken());
            turnGear(num, way);
            setConnect();
        }

        int ans = 0;
        for (int i = 1; i < 5; i++) {
            if (gears[i].getNS(1) == 1) ans |= (1 << (i-1));
        }
        System.out.println(ans);
        br.close();
    }

    public static void turnGear(int num, int way) {
        if (num == 1) {
            gears[num].turn(way);
            if (check[0]) {     // 극이 다름
                gears[num+1].turn(way*(-1));
                if (check[1]) {
                    gears[num+2].turn(way);
                    if (check[2]) {
                        gears[num+3].turn(way*(-1));
                    }
                }
            }
        }
        else if (num == 2) {
            gears[num].turn(way);
            if (check[0]) {
                gears[num-1].turn(way*(-1));
            }
            if (check[1]) {
                gears[num+1].turn(way*(-1));
                if (check[2]) {
                    gears[num+2].turn(way);
                }
            }
        }
        else if (num == 3) {
            gears[num].turn(way);
            if (check[2]) {
                gears[num+1].turn(way*(-1));
            }
            if (check[1]) {
                gears[num-1].turn(way*(-1));
                if (check[0]) {
                    gears[num-2].turn(way);
                }
            }
        }
        else {
            gears[num].turn(way);
            if (check[2]) {     // 극이 다름
                gears[num-1].turn(way*(-1));
                if (check[1]) {
                    gears[num-2].turn(way);
                    if (check[0]) {
                        gears[num-3].turn(way*(-1));
                    }
                }
            }
        }
    }

    public static void setConnect() {
        check[0] = (gears[1].getNS(3) != gears[2].getNS(7));
        check[1] = (gears[2].getNS(3) != gears[3].getNS(7));
        check[2] = (gears[3].getNS(3) != gears[4].getNS(7));
    }

    public static class Gear {
        int NS = 0;
        public void addNS (int idx, int NS) {
            this.NS |= (NS << (8-idx));
        }

        public int getNS (int idx) {
            if ((NS & (1 << (8-idx))) != 0) {
                return 1;
            }
            else {
                return 0;
            }
        }

        public void turn(int way) {
            if (way == 1) {
                if ((NS & 1) > 0) {
                    NS >>= 1;
                    NS |= (1 << 7);
                    return;
                }
                NS >>= 1;
            }
            else {
                if ((NS & (1 << 7)) > 0) {
                    NS <<= 1;
                    NS |= 1;
                    return;
                }
                NS <<= 1;
            }
        }
    }
}
