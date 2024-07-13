import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] status = str.toCharArray();

        int length = status.length;
        int robot = 0, box = 0, destination = 0;
        for (int i = 0; i < length; i++) {
            if (status[i] == '@') {
                robot = i;
            } else if (status[i] == '#') {
                box = i;
            } else if (status[i] == '!') {
                destination = i;
            }
        }

        int answer = -1;
        if (destination > box && box > robot) {
            answer = destination - robot - 1;
        } else if (destination < box && box < robot) {
            answer = robot - destination - 1;
        }

        System.out.println(answer);
    }
}