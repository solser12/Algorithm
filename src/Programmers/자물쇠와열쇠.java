package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 자물쇠와열쇠 {

    public boolean solution(int[][] key, int[][] lock) {

        ArrayList<Loc> lockLocs = new ArrayList<>();
        for (int i = 0; i < lock.length; i++ ){
            for (int j = 0; j < lock.length; j++) {
                if (lock[i][j] == 0) {
                    lockLocs.add(new Loc(i, j));
                }
            }
        }

        if (lockLocs.size() == 0) {
            return true;
        }

        ArrayList<Loc> first = new ArrayList<>();
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if (key[i][j] == 1) {
                    first.add(new Loc(i, j));
                }
            }
        }
        Key k = new Key(key.length, first);

        Queue<Loc> temp = new LinkedList<>();
        for (int i = -k.keySize + 1; i < lock.length; i++) {
            for (int j = -k.keySize + 1; j < lock.length; j++) {
                for (ArrayList<Loc> loc : k.locs) {
                    boolean check = true;
                    for (Loc l : loc) {
                        int x = i + l.x;
                        int y = j + l.y;
                        if (0 <= x && x < lock.length && 0 <= y && y < lock.length) {
                            if (lock[x][y] == 0) {
                                lock[x][y] = 1;
                                temp.add(new Loc(x, y));
                            } else {
                                check = false;
                                break;
                            }
                        }
                    }

                    if (check) {
                        for (Loc lockLoc : lockLocs) {
                            if (lock[lockLoc.x][lockLoc.y] == 0) {
                                check = false;
                                break;
                            }
                        }

                        if (check) {
                            return true;
                        }
                    }

                    while (!temp.isEmpty()) {
                        Loc l = temp.poll();
                        lock[l.x][l.y] = 0;
                    }
                }
            }
        }

        return false;
    }

    public class Key {

        int keySize;
        ArrayList<Loc>[] locs;

        public Key(int keySize, ArrayList<Loc> first) {
            this.keySize = keySize;
            this.locs = new ArrayList[4];
            for (int i = 1; i < 4; i++ ){
                locs[i] = new ArrayList<>();
            }

            locs[0] = first;
            for (int i = 1; i < 4; i++) {
                for (Loc loc : locs[i - 1]) {
                    locs[i].add(new Loc(loc.y, keySize - loc.x - 1));
                }
            }
        }
    }

    public class Loc {

        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
