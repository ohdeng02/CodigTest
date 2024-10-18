import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static int[] lengths = new int[6];
    
    public static int findCutted(int index) {
        if (index == 0) {
            return Math.abs(lengths[index + 1] - lengths[5]);
        } else if (index == 5) {
            return Math.abs(lengths[index - 1] - lengths[0]);
        } else {
            return Math.abs(lengths[index - 1] - lengths[index + 1]);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        int maxWidth = 0, maxHeight = 0;
        int widthIdx = 0, heightIdx = 0;
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());
            lengths[i] = Integer.parseInt(st.nextToken());
            if (dir == 1 || dir == 2) {
                if (lengths[i] > maxWidth) {
                    maxWidth = lengths[i];
                    widthIdx = i;
                }
            } else {
                if (lengths[i] > maxHeight) {
                    maxHeight = lengths[i];
                    heightIdx = i;
                }
            }
        }

        int cutWidth = findCutted(heightIdx);
        int cutHeight = findCutted(widthIdx);
        System.out.println(k * (maxWidth * maxHeight - cutWidth * cutHeight));
    }
}