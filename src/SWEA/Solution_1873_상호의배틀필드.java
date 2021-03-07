package SWEA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Solution_1873_상호의배틀필드 {

    static char[][] map;
    static int[] loc = new int[3];
    static int H, W;

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            String input;

            for (int i = 0; i < H; i++) {
                input = br.readLine();
                for ( int j = 0; j < W; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] == '<' || map[i][j] == '^' || map[i][j] == '>' || map[i][j] == 'v') {
                        loc[0] = i;
                        loc[1] = j;
                        switch (map[i][j]) {
                            case '^':
                                loc[2] = 0;
                                break;
                            case 'v':
                                loc[2] = 1;
                                break;
                            case '<':
                                loc[2] = 2;
                                break;
                            case '>':
                                loc[2] = 3;
                                break;
                        }
                    }
                }
            }
            

            int N = Integer.parseInt(br.readLine());
            input = br.readLine();

            for (int i = 0; i < N; i++) {
                switch (input.charAt(i)) {
                    case 'U':		// Up
                        Up();
                        break;
                    case 'D':		// Down
                        Down();
                        break;
                    case 'L':		// Left
                        Left();
                        break;
                    case 'R':		// Right
                        Rigth();
                        break;
                    case 'S':		// Shoot
                        Shoot();
                        break;
                }
            }

            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    public static void Up() {
        loc[2] = 0;
        map[loc[0]][loc[1]] = '^';
        if (loc[0]-1 < 0 || map[loc[0]-1][loc[1]] == '#' || map[loc[0]-1][loc[1]] == '*' || map[loc[0]-1][loc[1]] == '-') return;
        else {
            map[loc[0]][loc[1]] = '.';
            map[--loc[0]][loc[1]] = '^';
        }
    }

    public static void Down() {
        loc[2] = 1;
        map[loc[0]][loc[1]] = 'v';
        if (loc[0]+1 >= H || map[loc[0]+1][loc[1]] == '#' || map[loc[0]+1][loc[1]] == '*' || map[loc[0]+1][loc[1]] == '-') return;
        else {
            map[loc[0]][loc[1]] = '.';
            map[++loc[0]][loc[1]] = 'v';

        }
    }

    public static void Left() {
        loc[2] = 2;
        map[loc[0]][loc[1]] = '<';
        if (loc[1]-1 < 0 || map[loc[0]][loc[1]-1] == '#' || map[loc[0]][loc[1]-1] == '*' || map[loc[0]][loc[1]-1] == '-') return;
        else {
            map[loc[0]][loc[1]] = '.';
            map[loc[0]][--loc[1]] = '<';
        }
    }

    public static void Rigth() {
        loc[2] = 3;
        map[loc[0]][loc[1]] = '>';
        if (loc[1]+1 >= W || map[loc[0]][loc[1]+1] == '#' || map[loc[0]][loc[1]+1] == '*' || map[loc[0]][loc[1]+1] == '-') return;
        else {
            map[loc[0]][loc[1]] = '.';
            map[loc[0]][++loc[1]] = '>';
        }
    }

    public static void Shoot() {
        int[] bullet = new int[2];
        bullet[0] = loc[0];
        bullet[1] = loc[1];

        switch (loc[2]) {
            case 0:
                while (true) {
                    bullet[0]--;
                    if (bullet[0] < 0 || map[bullet[0]][bullet[1]] == '#') return;
                    else if (map[bullet[0]][bullet[1]] == '*') {
                        map[bullet[0]][bullet[1]] = '.';
                        return;
                    }
                }
            case 1:
                while (true) {
                    bullet[0]++;
                    if (bullet[0] >= H || map[bullet[0]][bullet[1]] == '#') return;
                    else if (map[bullet[0]][bullet[1]] == '*') {
                        map[bullet[0]][bullet[1]] = '.';
                        return;
                    }
                }
            case 2:
                while (true) {
                    bullet[1]--;
                    if (bullet[1] < 0 || map[bullet[0]][bullet[1]] == '#') return;
                    else if (map[bullet[0]][bullet[1]] == '*') {
                        map[bullet[0]][bullet[1]] = '.';
                        return;
                    }
                }
            case 3:
                while (true) {
                    bullet[1]++;
                    if (bullet[1] >= W || map[bullet[0]][bullet[1]] == '#') return;
                    else if (map[bullet[0]][bullet[1]] == '*') {
                        map[bullet[0]][bullet[1]] = '.';
                        return;
                    }
                }
        }
    }
}