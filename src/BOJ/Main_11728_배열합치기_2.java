package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11728_배열합치기_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int aCnt = 1;
        int bCnt = 1;

        StringBuilder sb = new StringBuilder();
        StringTokenizer A = new StringTokenizer(br.readLine());
        StringTokenizer B = new StringTokenizer(br.readLine());

        int aNum = Integer.parseInt(A.nextToken());
        int bNum = Integer.parseInt(B.nextToken());
        while (true) {
            if (aNum < bNum) {
                addString(sb, aNum);
                if (aCnt == N) {
                    addString(sb, bNum);
                    for (int i = bCnt; i < M; i++) {
                        addString(sb, Integer.parseInt(B.nextToken()));
                    }
                    break;
                }
                aCnt++;
                aNum = Integer.parseInt(A.nextToken());
            } else {
                addString(sb, bNum);
                if (bCnt == M) {
                    addString(sb, aNum);
                    for (int i = aCnt; i < N; i++) {
                        addString(sb, Integer.parseInt(A.nextToken()));
                    }
                    break;
                }
                bCnt++;
                bNum = Integer.parseInt(B.nextToken());
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static void addString(StringBuilder sb, int num) {
        sb.append(num).append(' ');
    }
}