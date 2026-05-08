import java.util.*;

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int solution(String dirs) {
        int answer = 0;
        
        int currX = 5; //좌표
        int currY = 5;
        boolean[][][] board = new boolean[11][11][4]; //선분 위치
        int dir = 0; // 이동방향
    
        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int mx = currX, my = currY;
            if (ch == 'U') {
                mx += dx[3];
                my += dy[3];
                dir = 1;
            } else if (ch == 'D') {
                mx += dx[1];
                my += dy[1];
                dir = 3;
            } else if (ch == 'R') {
                mx += dx[0];
                my += dy[0];
                dir = 2;
            } else {
                mx += dx[2];
                my += dy[2];
                dir = 0;
            }
            
            if (mx >= 0 && mx < 11 && my >= 0 && my < 11) {
                if (!board[my][mx][dir]) {
                    board[my][mx][dir] = true;
                    board[currY][currX][(dir + 2) % 4] = true;
                    answer++;
                }
                currX = mx;
                currY = my;
            }
        }
        return answer;
    }
}