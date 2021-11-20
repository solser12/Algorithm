package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_5373_큐빙 {

    public static HashMap<Integer, Character> sideColorMap = new HashMap<>();
    public static HashMap<Character, Integer> sideIndexMap = new HashMap<>();
    public static Side[] cube;
    public static int[][][] edgeMapping = {
            {{2, 0, 2}, {2, 0, 1}, {2, 0, 0}, {4, 2, 2}, {4, 1, 2}, {4, 0, 2}, {3, 2, 0}, {3, 2, 1}, {3, 2, 2}, {5, 0, 0}, {5, 1, 0}, {5, 2, 0}},
            {{2, 2, 0}, {2, 2, 1}, {2, 2, 2}, {5, 2, 2}, {5, 1, 2}, {5, 0, 2}, {3, 0, 2}, {3, 0, 1}, {3, 0, 0}, {4, 0, 0}, {4, 1, 0}, {4, 2, 0}},
            {{0, 2, 0}, {0, 2, 1}, {0, 2, 2}, {5, 2, 0}, {5, 2, 1}, {5, 2, 2}, {1, 0, 2}, {1, 0, 1}, {1, 0, 0}, {4, 2, 0}, {4, 2, 1}, {4, 2, 2}},
            {{1, 2, 0}, {1, 2, 1}, {1, 2, 2}, {5, 0, 2}, {5, 0, 1}, {5, 0, 0}, {0, 0, 2}, {0, 0, 1}, {0, 0, 0}, {4, 0, 2}, {4, 0, 1}, {4, 0, 0}},
            {{0, 0, 0}, {0, 1, 0}, {0, 2, 0}, {2, 0, 0}, {2, 1, 0}, {2, 2, 0}, {1, 0, 0}, {1, 1, 0}, {1, 2, 0}, {3, 0, 0}, {3, 1, 0}, {3, 2, 0}},
            {{3, 2, 2}, {3, 1, 2}, {3, 0, 2}, {1, 2, 2}, {1, 1, 2}, {1, 0, 2}, {2, 2, 2}, {2, 1, 2}, {2, 0, 2}, {0, 2, 2}, {0, 1, 2}, {0, 0, 2}}
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        mapping();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            makeCube();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                String order = st.nextToken();
                if (order.charAt(1) == '+') {
                    cube[sideIndexMap.get(order.charAt(0))].clockWise();
                } else {
                    cube[sideIndexMap.get(order.charAt(0))].counterClockWise();
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(cube[0].color[i][j]);
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static void makeCube() {
        cube = new Side[6];
        for (int i = 0; i < 6; i++) {
            cube[i] = new Side(sideColorMap.get(i), i);
        }
    }

    public static void mapping() {
        sideColorMap.put(0, 'w');
        sideColorMap.put(1, 'y');
        sideColorMap.put(2, 'r');
        sideColorMap.put(3, 'o');
        sideColorMap.put(4, 'g');
        sideColorMap.put(5, 'b');

        sideIndexMap.put('U', 0);
        sideIndexMap.put('D', 1);
        sideIndexMap.put('F', 2);
        sideIndexMap.put('B', 3);
        sideIndexMap.put('L', 4);
        sideIndexMap.put('R', 5);
    }

    public static class Side {

        int type;
        char[][] color;

        public Side(char c, int type) {
            color = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    color[i][j] = c;
                }
            }

            this.type = type;
        }

        public void clockWise() {
            char temp1 = color[0][0];
            char temp2 = color[1][0];
            color[0][0] = color[2][0];
            color[1][0] = color[2][1];
            color[2][0] = color[2][2];
            color[2][1] = color[1][2];
            color[2][2] = color[0][2];
            color[1][2] = color[0][1];
            color[0][2] = temp1;
            color[0][1] = temp2;

            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) {
                temp[i] = cube[edgeMapping[type][i + 9][0]].color[edgeMapping[type][i + 9][1]][edgeMapping[type][i + 9][2]];
            }

            for (int i = 8; i >= 0; i--) {
                cube[edgeMapping[type][i + 3][0]].change(edgeMapping[type][i + 3][1], edgeMapping[type][i + 3][2],
                        cube[edgeMapping[type][i][0]].color[edgeMapping[type][i][1]][edgeMapping[type][i][2]]);
            }

            for (int i = 0; i < 3; i++) {
                cube[edgeMapping[type][i][0]].change(edgeMapping[type][i][1], edgeMapping[type][i][2], temp[i]);
            }
        }

        public void counterClockWise() {
            char temp1 = color[0][0];
            char temp2 = color[0][1];
            color[0][0] = color[0][2];
            color[0][1] = color[1][2];
            color[0][2] = color[2][2];
            color[1][2] = color[2][1];
            color[2][2] = color[2][0];
            color[2][1] = color[1][0];
            color[2][0] = temp1;
            color[1][0] = temp2;

            char[] temp = new char[3];
            for (int i = 0; i < 3; i++) {
                temp[i] = cube[edgeMapping[type][i][0]].color[edgeMapping[type][i][1]][edgeMapping[type][i][2]];
            }

            for (int i = 0; i < 9; i++) {
                cube[edgeMapping[type][i][0]].change(edgeMapping[type][i][1], edgeMapping[type][i][2],
                        cube[edgeMapping[type][i + 3][0]].color[edgeMapping[type][i + 3][1]][edgeMapping[type][i + 3][2]]);
            }

            for (int i = 9; i < 12; i++) {
                cube[edgeMapping[type][i][0]].change(edgeMapping[type][i][1], edgeMapping[type][i][2], temp[i - 9]);
            }
        }

        public void change(int x, int y, char c) {
            color[x][y] = c;
        }
    }
}
