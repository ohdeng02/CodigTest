import java.util.*;
import java.lang.*;
import java.io.*;

class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(st.nextToken() + " ");
            
            List<Integer> heights = new ArrayList<>();
            int cnt = 0;
            for (int j = 0; j < 20; j++) {
                int height = Integer.parseInt(st.nextToken());
                heights.add(height);
                for (int k = 0; k < j; k++) {
                    if (heights.get(k) > height) {
                        heights.remove(j);
                        heights.add(k, height);
                        cnt += j - k;
                        break;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}