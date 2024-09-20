import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int totalDay = 0;
        for (int i = 1; i < x; i++) {
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                totalDay += 30;
            } else if (i == 2) {
                totalDay += 28;
            } else {
                totalDay += 31;
            }
        }
        totalDay += y;

        System.out.println(days[totalDay % 7]);
    }
}