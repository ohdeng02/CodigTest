import java.util.*;
import java.io.*;

public class Main {
    static final int WALL = 6;
    static int N;
    static int M;
    static int[] xx = {-1, 0, 1, 0};
    static int[] yy = {0, 1, 0, -1};
    static int ans = Integer.MAX_VALUE;
    static ArrayList<Cctv> cctvs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int[][] arr = new int[N][M];
        cctvs = new ArrayList<Cctv>();

        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input2[j]);
                if (arr[i][j] != 0 && arr[i][j] != WALL) {
                    cctvs.add(new Cctv(j, i, arr[i][j]));
                }
            }
        }

        dfs(0, arr);
        System.out.println(ans);
    }

    public static void dfs(int cur, int[][] arr) {
        if (cur == cctvs.size()) {
            int temp = countZero(arr);
            ans = Math.min(ans, temp);
            return;
        }

        Cctv cctv = cctvs.get(cur);

        for (int i = 0; i < 4; i++) {
            int[] dirs = choice(cctv.number, i);
            int[][] temparr = copyArray(arr);
            for (int j = 0; j < dirs.length; j++) {
                temparr = fil(dirs[j], cctv, temparr);
            }
//            System.out.println("배열: ");
//            printArray(temparr);
            dfs(cur + 1, temparr);
        }
    }

    public static int countZero(int[][] tempArr) {
        int cnt = 0;
        for (int i = 0; i < tempArr.length; i++) {
            for (int j = 0; j < tempArr[i].length; j++) {
                if (tempArr[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    public static int[] choice(int cctv, int dir) {
        switch (cctv) {
            case 1:
                return new int[]{dir};

            case 2:
                if (dir % 2 == 0) {
                    return new int[]{0, 2};
                } else {
                    return new int[]{1, 3};
                }

            case 3:
                return new int[]{dir, (dir + 1) % 4};

            case 4:
                return new int[]{dir, (dir + 1) % 4, (dir + 2) % 4};

            case 5:
                return new int[]{0, 1, 2, 3};
        }
        return new int[]{};
    }

    public static int[][] fil(int dir, Cctv cctv, int[][] tempArr) {
        int x = cctv.x;
        int y = cctv.y;

        while (true) {
            x = x + xx[dir];
            y = y + yy[dir];
            if (x < 0 || x >= M || y < 0 || y >= N || tempArr[y][x] == WALL)
                break;
            if (tempArr[y][x] == 0) {
                tempArr[y][x] = -1;
            }
        }

        return tempArr;
    }

    public static int[][] copyArray(int[][] arr) {
        int[][] newArray = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i].clone();
        }
        return newArray;
    }

    public static class Cctv {
        int x, y, number;

        public Cctv(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }
    }
}