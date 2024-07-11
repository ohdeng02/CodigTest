import java.util.*;
import java.io.*;

class Main {

    static int[] switches;
    
    public static void swap(int index) {
        switches[index] = switches[index] == 1 ? 0 : 1;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        switches = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }
        
        int student = Integer.parseInt(br.readLine());
        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                for (int j = number; j <= n; j++) {
                    if (j % number == 0) {
                        swap(j - 1);
                    }
                }
            } else {
                int limit = Math.min(n - number, number - 1);
                for (int j = 1; j <= limit; j++) {
                    if (switches[number - j - 1] == switches[number + j - 1]) {
                        swap(number - j - 1);
                        swap(number + j - 1);
                    } else {
                        break;
                    }
                }
                swap(number - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(switches[i] + " ");
            if ((i + 1) % 20 == 0) System.out.println();
        }

    }
}