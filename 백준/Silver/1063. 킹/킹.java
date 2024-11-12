import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int kingX;
    static int kingY;
    static int rockX;
    static int rockY;
    static int dx = 0, dy = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String rock = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        kingX = king.charAt(0) - 'A';
        kingY = 8 - (king.charAt(1) - '0');
        rockX = rock.charAt(0) - 'A';
        rockY = 8 - (rock.charAt(1) - '0');
        for (int i = 0; i < N; i++) {
            String direction = br.readLine();
            move(kingX, kingY, direction);
            if (dx >= 0 && dx < 8 && dy >= 0 && dy < 8) {
                if (dx == rockX && dy == rockY) {
                    moveRock(dx, dy, direction);
                } else {
                    kingX = dx;
                    kingY = dy;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append((char)('A' + kingX)).append(8 - kingY).append("\n");
        sb.append((char)('A' + rockX)).append(8 - rockY).append("\n");
        System.out.println(sb);
    }

    private static void move(int x, int y, String direction) {
        dx = x; dy = y;
        if (direction.equals("L")) {
            dx = x - 1;
        } else if (direction.equals("R")) {
            dx = x + 1;
        } else if (direction.equals("B")) {
            dy = y + 1;
        } else if (direction.equals("T")) {
            dy = y - 1;
        } else if (direction.equals("RT")) {
            dx = x + 1;
            dy = y - 1;
        } else if (direction.equals("LT")) {
            dx = x - 1;
            dy = y - 1;
        } else if (direction.equals("RB")) {
            dx = x + 1;
            dy = y + 1;
        } else {
            dx = x - 1;
            dy = y + 1;
        }
    }

    private static void moveRock(int x, int y, String direction) {
        int kingDx = x, kingDy = y;
        move(rockX, rockY, direction);
        if (dx >= 0 && dx < 8 && dy >= 0 && dy < 8) {
            rockX = dx;
            rockY = dy;
            kingX = kingDx;
            kingY = kingDy;
        }
    }
}