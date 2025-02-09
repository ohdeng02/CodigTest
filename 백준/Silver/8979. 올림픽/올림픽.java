import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main { // [Silver5] 8979번 : 올림픽
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] nation = new int[Integer.parseInt(st.nextToken())][4];
        int find = Integer.parseInt(st.nextToken());

        int tmp = 0;
        for (int i = 0; i < nation.length; i++) {
            st = new StringTokenizer(br.readLine());
            tmp = Integer.parseInt(st.nextToken()) - 1;
            nation[tmp][0] = Integer.parseInt(st.nextToken());
            nation[tmp][1] = Integer.parseInt(st.nextToken());
            nation[tmp][2] = Integer.parseInt(st.nextToken());
            nation[tmp][3] = tmp + 1;
        }
        Arrays.sort(nation, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    if (o1[1] == o2[1]) {
                        return o2[2] != o1[2] ? o2[2] - o1[2] : Math.abs(o1[3] - find) - Math.abs(o2[3] - find);
                    } else {
                        return o2[1] - o1[1];
                    }
                } else {
                    return o2[0] - o1[0];
                }
            }
        });
        for (int i = 0; i < nation.length; i++) {
            if (nation[i][3] == find) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}