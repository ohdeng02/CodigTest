import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[9];
        int sum = 0;

        for(int i=0; i<9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        
        int goal = sum - 100;
        for(int i = 0; i < 8; i++){
            for(int j = i+1; j < 9; j++){
                if(arr[i] + arr[j] == goal) {
                    arr[i] = 0; 
                    arr[j] = 0;
                    Arrays.sort(arr);
                    for(int k = 2; k < 9; k++){
                        //sb.append(arr[k] + "\n");
                        System.out.println(arr[k]);
                    }
                    
                    return;
                }
            }
        }
    }
}