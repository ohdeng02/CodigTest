import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static int[] heights = new int[9];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        
        for (int i = 0; i < 9; i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }
        findDwarf(sum);

        Arrays.sort(heights);
        for (int i = 2; i < 9; i++) {
            System.out.println(heights[i]);
        }
    }

    public static void findDwarf(int sum) {
        //전체합 - 2명 = 100
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (heights[i] + heights[j] == sum - 100) {
                    heights[i] = 0;
                    heights[j] = 0;
                    return;
                }
            }
        }
    }
}