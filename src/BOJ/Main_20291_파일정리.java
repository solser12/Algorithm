package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_20291_파일정리 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashMap<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String extension = st.nextToken();
            if (map.containsKey(extension)) {
                map.put(extension, map.get(extension) + 1);
            } else {
                map.put(extension, 1);
            }
        }

        Extension[] ans = new Extension[map.size()];
        int index = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans[index++] = new Extension(entry.getKey(), entry.getValue());
        }
        Arrays.sort(ans);

        StringBuilder sb = new StringBuilder();
        for (Extension e : ans) {
            sb.append(e.s).append(' ').append(e.cnt).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    public static class Extension implements Comparable<Extension> {

        String s;
        int cnt;

        public Extension(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Extension o) {
            return this.s.compareTo(o.s);
        }
    }
}
