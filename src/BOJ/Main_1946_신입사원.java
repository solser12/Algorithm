package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1946_신입사원 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            Applicant[] applicants = new Applicant[N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[i] = new Applicant(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            Arrays.sort(applicants);

            int cnt = 1, temp = applicants[0].interview;
            for (int i = 1; i < N; i++) {
                if (temp > applicants[i].interview) {
                    temp = applicants[i].interview;
                    cnt++;
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    public static class Applicant implements Comparable<Applicant> {
        int document, interview;

        public Applicant(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        @Override
        public int compareTo(Applicant o) {
            return this.document - o.document;
        }
    }
}
