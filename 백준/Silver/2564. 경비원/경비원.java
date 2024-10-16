import java.util.*;
import java.lang.*;
import java.io.*;

class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int[][] stores = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stores[i][0] = Integer.parseInt(st.nextToken());
            stores[i][1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(st.nextToken());
        int move = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int dirStore = stores[i][0];
            if ((dirStore == 1 && dir == 2) || (dirStore == 2 && dir == 1)) {
                int d1 = 2 * width - move - stores[i][1] + height;
                int d2 = height + move + stores[i][1];
                sum += Math.min(d1, d2);
            } else if ((dirStore == 1 && dir == 3) || (dirStore == 3 && dir == 1)) {
                sum += move + stores[i][1];
            } else if ((dirStore == 2 && dir == 4) || (dirStore == 4 && dir == 2)) {
                sum += width + height - move - stores[i][1];
            } else if ((dirStore == 3 && dir == 4) || (dirStore == 4 && dir == 3)) {
                int d1 = width + move + stores[i][1];
                int d2 = 2 * height + width - move - stores[i][1];
                sum += Math.min(d1, d2);
            } else if (dirStore == 1 && dir == 4) {
                sum += move + width - stores[i][1];
            } else if (dirStore == 4 && dir == 1) {
                sum += width + stores[i][1] - move;
            } else if (dirStore == 2 && dir == 3) {
                sum += height - move + stores[i][1];
            } else if (dirStore == 3 && dir == 2) {
                sum += move + height - stores[i][1];
            } else {
                sum += Math.abs(stores[i][1] - move);
            }
        }
        System.out.println(sum);
    }
}