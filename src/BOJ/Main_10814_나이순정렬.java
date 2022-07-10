package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10814_나이순정렬 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Member[] members = new Member[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            members[i] = new Member(i, Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(members);

        for (Member m : members) {
            sb.append(m.age).append(' ').append(m.name).append('\n');
        }
        System.out.println(sb);

        br.close();
    }

    public static class Member implements Comparable<Member> {

        int num, age;
        String name;

        public Member(int num, int age, String name) {
            this.num = num;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if (this.age == o.age) {
                return this.num - o.num;
            }
            return this.age - o.age;
        }
    }
}
