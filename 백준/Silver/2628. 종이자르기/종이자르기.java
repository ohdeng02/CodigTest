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
        List<Integer> rows = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();
        rows.add(0); rows.add(height);
        columns.add(0); columns.add(width);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());            
            if (line == 0) {
                rows.add(Integer.parseInt(st.nextToken()));
            } else {
                columns.add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(rows);
        Collections.sort(columns);
        int maxWidth = 0;
        int maxHeight = 0;
        for (int i = 1; i < rows.size(); i++) {
            maxHeight = Math.max(rows.get(i) - rows.get(i - 1), maxHeight);
        }
        for (int i = 1; i < columns.size(); i++) {
            maxWidth = Math.max(columns.get(i) - columns.get(i - 1), maxWidth);
        }

        System.out.println(maxWidth * maxHeight);
    }
}