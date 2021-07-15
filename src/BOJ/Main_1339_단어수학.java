package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1339_단어수학 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] ans1 = new int[26];
        int[] ans2 = new int[8];
        int ten = 1;
        for (int i = 0; i < 8; i++) {
            ans2[i] = ten;
            ten *= 10;
        }

        Node[] list = new Node[26];
        for (int i = 0; i < 26; i++) {
            list[i] = new Node(i, 0);
        }

        char[][] data = new char[N][];

        for (int i = 0; i < N; i++) {
           data[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int we = data[i][j] - 'A';
                list[we].weight += ans2[data[i].length - j - 1];
            }
        }

        Arrays.sort(list);

        for (int i = 0; i < 10; i++) {
            ans1[list[i].data] = 9 - i;
        }

        int result = 0;
        for (char[] chars : data) {
            for (int i = 0; i < chars.length; i++) {
                int num = chars[i] - 'A';
                result += ans1[num] * ans2[chars.length - 1 - i];
            }
        }

        System.out.println(result);
        br.close();
    }

    public static class Node implements Comparable<Node> {
        int data, weight;

        public Node(int data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return o.weight - this.weight;
        }
    }
}
