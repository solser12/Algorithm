package Programmers;

import java.util.HashMap;

public class 전화번호목록 {

    public boolean solution(String[] phone_book) {

        Trie trie = new Trie();

        for (String phoneNumber : phone_book) {
            if (!trie.insert(phoneNumber)) {
                return false;
            }
        }

        return true;
    }

    public class Trie {

        Node root = new Node();

        public boolean insert(String phoneNumber) {

            Node now = root;
            for (int i = 0; i < phoneNumber.length(); i++) {
                now = now.checkNumber(phoneNumber.charAt(0));
                if (now.isEnd) {
                    return false;
                }
            }
            now.isEnd = true;

            return !now.moreNext();
        }
    }

    public class Node {

        HashMap<Character, Node> next = new HashMap<>();
        boolean isEnd = false;

        public Node checkNumber(char num) {
            return next.computeIfAbsent(num, key -> new Node());
        }

        public boolean moreNext() {
            return next.size() != 0;
        }
    }
}
