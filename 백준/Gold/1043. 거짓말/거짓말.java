import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] party;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        int n, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken()); 
        m = Integer.parseInt(stk.nextToken()); 
        int k; 
        stk = new StringTokenizer(br.readLine());
        k = Integer.parseInt(stk.nextToken());
        int[] true_man = new int[k];
        for (int i = 0; i < k; i++) {
            true_man[i] = Integer.parseInt(stk.nextToken());
        } 

        parent = new int[n + 1];
        party = new ArrayList[m];
        for (int i = 0; i < m; i++) { // 파티의 수 만큼
            party[i] = new ArrayList<>();
            stk = new StringTokenizer(br.readLine());
            int party_size = Integer.parseInt(stk.nextToken());
            for (int j = 0; j < party_size; j++) {
                party[i].add(Integer.parseInt(stk.nextToken()));
            }
        }

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int first_man = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(first_man, party[i].get(j));
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int leader = party[i].get(0);
            boolean flag = true;
            for (int j = 0; j < k; j++) {
                if (isitsame(leader, true_man[j])) {
                    // 진실을 아는 사람과 같은 집합에 속한다면
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a; // 같은 집합으로 묶어주기
        }
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    public static boolean isitsame(int a, int b) {
        if (find(a) == find(b)) { // 같은 집합에 속한다면 true
            return true;
        } else return false;
    }
}