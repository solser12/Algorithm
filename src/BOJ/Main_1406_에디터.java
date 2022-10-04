package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1406_에디터 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Editor editor = new Editor(br.readLine().toCharArray());
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char order = st.nextToken().charAt(0);

            if (order == 'L') {
                editor.moveCursorLeft();
            } else if (order == 'D') {
                editor.moveCursorRight();
            } else if (order == 'B') {
                editor.delete();
            } else {
                editor.insert(st.nextToken().charAt(0));
            }
        }

        System.out.println(editor.print());
        br.close();
    }

    public static class Editor {

        Node start;
        Node cursor;

        public Editor(char[] input) {
            start = new Node();
            Node now = start;
            for (char c : input) {
                Node newNode = new Node(c);
                now.next = newNode;
                newNode.prev = now;
                now = now.next;
            }
            cursor = now;
        }

        public void moveCursorLeft() {
            if (cursor.prev != null) {
                cursor = cursor.prev;
            }
        }

        public void moveCursorRight() {
            if (cursor.next != null) {
                cursor = cursor.next;
            }
        }

        public void delete() {
            if (cursor != start) {
                cursor.prev.next = cursor.next;
                if (cursor.next != null) {
                    cursor.next.prev = cursor.prev;
                }
                cursor = cursor.prev;
            }
        }

        public void insert(char c) {
            Node newNode = new Node(c);

            if (cursor.next != null) {
                newNode.next = cursor.next;
                cursor.next.prev = newNode;
            }
            cursor.next = newNode;
            newNode.prev = cursor;
            cursor = newNode;
        }

        public String print() {
            StringBuilder sb = new StringBuilder();
            Node now = start.next;
            while (now != null) {
                sb.append(now.data);
                now = now.next;
            }
            return sb.toString();
        }
    }

    public static class Node {

        Node prev = null, next = null;
        char data;

        public Node() {}

        public Node(char data) {
            this.data = data;
        }
    }
}
