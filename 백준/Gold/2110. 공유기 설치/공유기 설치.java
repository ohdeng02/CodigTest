import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] house;
    
    // 거리값에 대해 설치 가능한 공유기 개수 찾기
	public static int countRouter(int distance) {
		int count = 1;
		int recentLoc = house[0];
		
		for (int i = 1; i < house.length; i++) {
			int loc = house[i];
			if (loc - recentLoc >= distance) {
				count++;
				recentLoc = loc;
			}
		}
		return count;
	}
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        Arrays.sort(house);	
		
		int lt = 1;		// 최소 거리가 될 수 있는 범위의 최솟값
		int rt = house[N - 1] - house[0] + 1;	// 최소 거리가 범위 최댓값
		
		while (rt > lt) {
			int mid = (rt + lt) / 2;
			
			// 설치 가능 공유기 개수 < M 개수 -> 거리를 좁히기 위해 rt 를 줄인다.
			if (C > countRouter(mid)) {
				rt = mid;
			} else {
				lt = mid + 1;
			}
		}

		System.out.println(lt - 1);
    }
}