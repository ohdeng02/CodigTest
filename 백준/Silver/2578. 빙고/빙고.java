import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static int[][] myNumbers;
    private static int[][] bingo;
    private static int size = 5;
    private static int bingoCnt = 0;

    public static void countRowBingo(int row) {
        for (int k = 0; k < size; k++) {
            if (myNumbers[row][k] != 0) {
                return;
            }
        }
        bingoCnt++;
    }

    public static void countColBingo(int col) {
        for (int k = 0; k < size; k++) {
            if (myNumbers[k][col] != 0) {
                return;
            }
        }
        bingoCnt++;
    }

    public static void countDownCrossBingo() {
        for (int i = size - 1; i >= 0; i--) { 
            if (myNumbers[i][size - i - 1] != 0) {
                return;
            }
        }
        bingoCnt++;
    }   

    public static void countUpCrossBingo() {
        for (int i = 0; i < size; i++) { 
            if (myNumbers[i][i] != 0) {
                return;
            }
        }
        bingoCnt++;
    }  

    public static void findBingo(int bingo, int i, int j) {
        if (myNumbers[i][j] == bingo) {
            myNumbers[i][j] = 0;
            countRowBingo(i);
            countColBingo(j);
            if (i + j == size - 1) {
                countDownCrossBingo();
            }
            if (i == j) {
                countUpCrossBingo();
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        myNumbers = new int[size][size];
        bingo = new int[size][size];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                myNumbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                int bingo = Integer.parseInt(st.nextToken());

                for (int l = 0; l < size; l++) {
                    for (int m = 0; m < size; m++) {
                        findBingo(bingo, l, m);
                    }
                }

                if (bingoCnt >= 3) {
                    System.out.println(size * i + j + 1);
                    return;
                }
            }
        }
        
    }
}