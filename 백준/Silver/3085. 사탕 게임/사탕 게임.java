import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int max = 0;
    static char[][] candies;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        candies = new char[N][N];
        
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            candies[i] = s.toCharArray();
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i < N-1) {
                    swap(i, j, i+1, j);
                    countMax();
                    swap(i+1, j, i, j);
                }
                if(j < N-1) {
                    swap(i, j, i, j+1);
                    countMax();
                    swap(i, j+1, i, j);
                }
            }
        }
        System.out.println(max);
    }
    

    static void countMax() {
        for(int i = 0; i < N; i++){
            int count = 1;
            for(int j = 0; j < N-1; j++){
                if(candies[i][j] == candies[i][j+1]){
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }

        for(int i = 0; i < N; i++){
            int count = 1;
            for(int j = 0; j < N-1; j++){
                if(candies[j][i] == candies[j+1][i]){
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
            }
        }
    }

    static void swap(int i, int j, int l, int m) {
        char temp = candies[i][j];
        candies[i][j] = candies[l][m];
        candies[l][m] = temp;
    }
}