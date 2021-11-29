package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_17081_RPGExtreme {

    public static int N, M;
    public static char[][] map;
    public static int[][] indexCheck;
    public static Monster[] monsters;
    public static Item[] items;
    public static Hero hero;
    public static char[] command;
    public static Loc startLoc;

    public static void main(String[] args) throws IOException {

        start();

        int turn = 0;
        Loc loc = startLoc;
        for (char c : command) {
            turn++;
            loc = hero.move(c);
            char object = map[loc.x][loc.y];

            if (object == '^') {
                if (hero.stepOnSpike() && hero.die()) {
                    System.out.println(showResult(turn, 1, "SPIKE TRAP"));
                    System.exit(0);
                }
            } else if (object == 'B') {
                Item item = items[indexCheck[loc.x][loc.y]];
                if (item.type == 'W') {
                    hero.wearWeapon(item.val);
                } else if (item.type == 'A') {
                    hero.wearArmor(item.val);
                } else {
                    hero.wearAccessory(item.val);
                }
                map[loc.x][loc.y] = '.';
            } else if (object == '&') {
                Monster monster = monsters[indexCheck[loc.x][loc.y]];
                if (hero.battle(monster, false)) {
                    if (hero.die()) {
                        System.out.println(showResult(turn, 1, monster.name));
                        System.exit(0);
                    }
                } else {
                    map[loc.x][loc.y] = '.';
                }
            } else if (object == 'M') {
                Monster monster = monsters[indexCheck[loc.x][loc.y]];
                if (hero.battle(monster, true)) {
                    if (hero.die()) {
                        System.out.println(showResult(turn, 1, monster.name));
                        System.exit(0);
                    }
                } else {
                    map[loc.x][loc.y] = '@';
                    System.out.println(showResult(turn, 0, null));
                    System.exit(0);
                }
            }
        }

        map[loc.x][loc.y] = '@';
        System.out.println(showResult(turn, 2, null));
    }

    public static String showResult(int turn, int type, String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        sb.append("Passed Turns : ").append(turn).append('\n');
        sb.append("LV : ").append(hero.level).append('\n');
        sb.append("HP : ").append(hero.curHp).append('/').append(hero.maxHp).append('\n');
        sb.append("ATT : ").append(hero.attack).append('+').append(hero.weapon).append('\n');
        sb.append("DEF : ").append(hero.defense).append('+').append(hero.armor).append('\n');
        sb.append("EXP : ").append(hero.curExp).append('/').append(hero.maxExp).append('\n');
        if (type == 0) {
            sb.append("YOU WIN!\n");
        } else if (type == 1) {
            sb.append("YOU HAVE BEEN KILLED BY ").append(name).append("..\n");
        } else {
            sb.append("Press any key to continue.\n");
        }

        return sb.toString();
    }

    public static void start() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        indexCheck = new int[N][M];

        int monsterCount = 0, itemCount = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            Arrays.fill(indexCheck[i], -1);
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);
                if (c == '@') {
                    hero = new Hero(new Loc(i, j));
                    startLoc = new Loc(i, j);
                    map[i][j] = '.';
                } else {
                    map[i][j] = c;
                    if (c == '&' || c == 'M') {
                        monsterCount++;
                    } else if (c == 'B') {
                        itemCount++;
                    }
                }
            }
        }
        monsters = new Monster[monsterCount];
        items = new Item[itemCount];

        command = br.readLine().toCharArray();

        for (int i = 0; i < monsterCount; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            String name = st.nextToken();
            int attack = Integer.parseInt(st.nextToken());
            int defense = Integer.parseInt(st.nextToken());
            int hp = Integer.parseInt(st.nextToken());
            int exp = Integer.parseInt(st.nextToken());
            indexCheck[x][y] = i;
            monsters[i] = new Monster(name, attack, defense, hp, exp);
        }

        HashMap<String, Integer> accMap = new HashMap<>();
        accMap.put("HR", 0);
        accMap.put("RE", 1);
        accMap.put("CO", 2);
        accMap.put("EX", 3);
        accMap.put("DX", 4);
        accMap.put("HU", 5);
        accMap.put("CU", 6);

        for (int i = 0; i < itemCount; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            char type = st.nextToken().charAt(0);
            int val;
            if (type == 'O') {
                val = accMap.get(st.nextToken());
            } else {
                val = Integer.parseInt(st.nextToken());
            }
            indexCheck[x][y] = i;
            items[i] = new Item(type, val);
        }

        br.close();
    }

    public static class Hero {

        Loc loc;
        int maxHp = 20, curHp = 20, level = 1, curExp = 0, maxExp = 5, attack = 2,
                defense = 2, armor = 0, weapon = 0, accCount = 0;
        boolean[] accessories = new boolean[7]; // HR, RE, CO, EX, DX, HU, CU
        int[][] dt = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        HashMap<Character, Integer> commandMap = new HashMap<>();

        public Hero(Loc loc) {
            this.loc = loc;
            commandMap.put('U', 0);
            commandMap.put('L', 1);
            commandMap.put('D', 2);
            commandMap.put('R', 3);
        }

        public Loc move(char c) {
            int d = commandMap.get(c);
            int dx = loc.x + dt[d][0];
            int dy = loc.y + dt[d][1];
            if (check(dx, dy)) {
                this.loc.x = dx;
                this.loc.y = dy;
                return loc;
            }
            return loc;
        }

        // 죽었을 때
        public boolean die() {
            if (!accessories[1]) {
                curHp = 0;
                return true;
            }

            this.loc = new Loc(startLoc.x, startLoc.y);
            curHp = maxHp;
            accessories[1] = false;
            return false;
        }

        public boolean battle(Monster monster, boolean isBoss) {

            // 첫번째 공격
            int monsterHp = monster.hp;
            int totalAttack = attack + weapon;
            int totalDefense = defense + armor;
            int heroDamage = Math.max(1, totalAttack - monster.defense);
            if (accessories[2]) monsterHp -= Math.max(1, (totalAttack * (accessories[4] ? 3 : 2)) - monster.defense);
            else monsterHp -= heroDamage;
            if (monsterHp <= 0) {
                win(monster.exp);
                return false;
            }

            // 첫번째 방어
            int monsterDamage = Math.max(1, monster.attack - totalDefense);
            if (isBoss && accessories[5]) curHp = maxHp;
            else curHp -= monsterDamage;
            if (curHp <= 0) return true;

            // 그 후
            int heroHit = (monsterHp / heroDamage) + ((monsterHp % heroDamage == 0) ? 0 : 1);
            int totalMonsterDamage = monsterDamage * (heroHit - 1);
            if (curHp <= totalMonsterDamage) return true;
            curHp -= totalMonsterDamage;
            win(monster.exp);
            return false;
        }

        // 승리했을 시
        public void win(int exp) {
            if (accessories[0]) {
                curHp = Math.min(curHp + 3, maxHp);
            }

            curExp += (int) (exp * (accessories[3] ? 1.2 : 1));

            // 레벨업
            if (curExp >= maxExp) {
                level++;
                curExp = 0;
                maxExp = level * 5;
                maxHp += 5;
                curHp = maxHp;
                attack += 2;
                defense += 2;
            }
        }

        // 스파이크 밟았을 때
        public boolean stepOnSpike() {
            curHp -= accessories[4] ? 1 : 5;
            return curHp <= 0;
        }

        // 무기 착용
        public void wearWeapon(int weapon) { this.weapon = weapon; }

        // 방어구 착용
        public void wearArmor(int armor) {
            this.armor = armor;
        }

        // 악세사리 착용
        public void wearAccessory(int type) {
            if (accCount < 4 && !accessories[type]) {
                accessories[type] = true;
                accCount++;
            }
        }

        public boolean check(int x, int y) {
            return x >= 0 && x < N && y >= 0 && y < M && map[x][y] != '#';
        }
    }

    public static class Item {
        char type;
        int val;

        public Item(char type, int val) {
            this.type = type;
            this.val = val;
        }
    }

    public static class Monster {
        String name;
        int attack, defense, hp, exp;

        public Monster(String name, int attack, int defense, int hp, int exp) {
            this.name = name;
            this.attack = attack;
            this.defense = defense;
            this.hp = hp;
            this.exp = exp;
        }
    }

    public static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
