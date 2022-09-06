package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1269_대칭차집합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        HashSet<Integer> aSet = new HashSet<>();
        HashSet<Integer> bSet = new HashSet<>();
        int[] aList = new int[aSize];
        int[] bList = new int[bSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            int num = Integer.parseInt(st.nextToken());
            aSet.add(num);
            aList[i] = num;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            int num = Integer.parseInt(st.nextToken());
            bSet.add(num);
            bList[i] = num;
        }

        for (int i : aList) {
            bSet.remove(i);
        }
        for (int i : bList) {
            aSet.remove(i);
        }

        System.out.println(aSet.size() + bSet.size());
        br.close();
    }
}
