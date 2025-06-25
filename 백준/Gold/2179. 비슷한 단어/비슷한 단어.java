import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int maxCnt = 0;
        int sIdx = 0, tIdx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int len = Math.min(words[i].length(), words[j].length());
                int count = 0;
                for (int k = 0; k < len; k++) {
                    if (words[j].charAt(k) == words[i].charAt(k)) count++;
                    else break;
                }
                if (count > maxCnt) {
                    maxCnt = count;
                    sIdx = i;
                    tIdx = j;
                }
            }
        }

        System.out.println(words[sIdx] + "\n" + words[tIdx]);
    }
}