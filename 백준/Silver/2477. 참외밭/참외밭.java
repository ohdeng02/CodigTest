import java.util.*;
import java.io.*;

class Main {
    static int[] length;
    
    static int cuttedLength(int idx) {
        int len = 0;
        if(idx == 0){
            len = Math.abs(length[5] - length[1]);
        } else if (idx == 5){
            len = Math.abs(length[0] - length[4]);
        } else {
            len = Math.abs(length[idx-1] - length[idx+1]);
        }
        return len;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        length = new int[6];
        int K = Integer.parseInt(br.readLine());

        int maxHeight = 0;
        int maxWidth = 0;
        int heightIdx = 0, widthIdx = 0;
        
        for(int i = 0; i < 6; i++){
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            length[i] = Integer.parseInt(st.nextToken());

            if((direction == 1 || direction == 2) && maxWidth < length[i]) {
                maxWidth = length[i];
                widthIdx = i;
            } else if((direction == 3 || direction == 4) && maxHeight < length[i]) {
                maxHeight = length[i];
                heightIdx = i;
            }
        }
        int cuttedArea = cuttedLength(heightIdx) * cuttedLength(widthIdx);
        int result = (maxHeight * maxWidth - cuttedArea) * K;
        System.out.println(result);
    }
}