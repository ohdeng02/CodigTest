import java.util.*;
import java.io.*;

class Time implements Comparable<Time> {
    public int s, e;
    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        if (this.e == o.e) return this.s - o.s;
        else return  this.e - o.e;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Time> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.add(new Time(s, e));
        }

        Collections.sort(arr);

        int cnt = 1;
        int lastEnd = arr.get(0).e;
        for (int i = 1; i < N; i++) {
            if (arr.get(i).s >= lastEnd) {
                cnt++;
                lastEnd = arr.get(i).e;
            }
        }

        System.out.println(cnt);
    }
}