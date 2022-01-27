package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5639_이진검색트리 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input = "";
        while ((input = br.readLine()) != null) {
            int num = Integer.parseInt(input);
            root.insert(num);
        }

         root.postorder(sb);

        System.out.println(sb);
        br.close();
    }

    public static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public void insert(int num) {
            if (value > num) {
                if (left == null) left = new Node(num);
                else left.insert(num);
            } else {
                if (right == null) right = new Node(num);
                else right.insert(num);
            }
        }

        public void postorder(StringBuilder sb) {
            if (left != null) left.postorder(sb);
            if (right != null) right.postorder(sb);
            sb.append(value).append('\n');
        }
    }
}
