package Programmers.kakao2021internship;

import java.util.Stack;
import java.util.StringTokenizer;

public class 표편집 {

    public static void main(String[] args) {

        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        solution(8, 2, cmd);
    }

    public static String solution(int n, int k, String[] cmd) {

        Program program = new Program();
        for (int i = 0; i < n; i++) {
            program.addNode();
        }
        program.startPointer(k);

        StringTokenizer st;
        for (String s : cmd) {
            st = new StringTokenizer(s);
            char type = st.nextToken().charAt(0);

            if (type == 'U') {
                program.up(Integer.parseInt(st.nextToken()));
            } else if (type == 'D') {
                program.down(Integer.parseInt(st.nextToken()));
            } else if (type == 'C') {
                program.delete();
            } else {
                program.restore();
            }
        }

        System.out.println(program.getResult(n));
        return program.getResult(n);
    }

    public static class Program {

        Node front = null, end = null;
        int size = 0;
        Node pointer;
        Stack<Node> remove = new Stack<>();

        public void addNode() {

            if (front == null) {
                front = new Node(size);
                end = front;
            } else {
                Node node = new Node(size);
                end.next = node;
                node.prev = end;
                end = node;
            }

            size++;
        }

        public void startPointer(int k) {
            Node temp = front;
            while (!(temp.value == k)) {
                temp = temp.next;
            }
            pointer = temp;
        }

        public void up(int x) {
            for (int i = 0; i < x; i++) {
                pointer = pointer.prev;
            }
        }

        public void down(int x) {
            for (int i = 0; i < x; i++) {
                pointer = pointer.next;
            }
        }

        public void delete() {
            remove.push(pointer);

            if (pointer == end) {
                end = pointer.prev;
                pointer.prev.next = null;
                pointer = pointer.prev;
            } else {
                if (pointer == front) {
                    front = pointer.next;
                    pointer.next.prev = null;
                } else {
                    pointer.prev.next = pointer.next;
                    pointer.next.prev = pointer.prev;
                }
                pointer = pointer.next;
            }
        }

        public void restore() {
            Node node = remove.pop();

            if (node.prev != null) {
                node.prev.next = node;
            } else {
                front = node;
            }

            if (node.next != null) {
                node.next.prev = node;
            } else {
                end = node;
            }
        }

        public String getResult(int n) {
            StringBuilder sb = new StringBuilder();

            Node node = front;
            for (int i = 0; i < n; i++) {
                if (node.value == i) {
                    sb.append('O');
                    if (node.next != null) {
                        node = node.next;
                    }
                } else {
                    sb.append('X');
                }
            }

            return sb.toString();
        }
    }

    public static class Node {
        Node prev = null, next = null;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
