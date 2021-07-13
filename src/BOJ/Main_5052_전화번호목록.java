package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_5052_전화번호목록 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            Trie trie = new Trie();

            int N = Integer.parseInt(br.readLine());
            int n = 0;
            boolean isSame = false;

            for (; n < N; n++) {
                char[] input = br.readLine().toCharArray();
                if (trie.check(input)) {
                    isSame = true;
                    n++;
                    break;
                }
            }

            for (; n < N; n++) {
                br.readLine();
            }

            if (isSame) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }

        System.out.print(sb);
        br.close();
    }

    public static class Node {

        private Map<Integer, Node> child = new HashMap<>();
        private boolean isLast = false;

        public Node makeChild(int num) {
            child.put(num, new Node());
            return child.get(num);
        }
    }

    public static class Trie {

        private Node root;

        public Trie() {
            this.root = new Node();
        }

        // 확인하면서 삽입
        public boolean check(char[] num) {
            Node now = root;
            for (int i = 0; i < num.length; i++) {

                // 자식 노드 가져오기
                Node node = now.child.get(num[i] - '0');

                // 자식 노드가 없으면 생성
                if (node == null) {
                    node = now.makeChild(num[i] - '0');
                } else {
                    // 마지막 문자인지 확인
                    if (node.isLast) {
                        return true;
                    }

                    // 마지막 문자인데 노드가 있으면 중복
                    if (i == num.length - 1) {
                        return true;
                    }
                }

                now = node;
            }

            // 마지막이면 표시
            now.isLast = true;

            return false;
        }
    }
}
