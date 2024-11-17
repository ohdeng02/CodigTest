import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] box;
	static int[][] dis;
	static int[] dy = {0, -1, 0, 1};
	static int[] dx = {1, 0, -1, 0};
	static int N, M;
	static Queue<List<Integer>> queue = new LinkedList<>();
	
	static void BFS() {
		while (!queue.isEmpty()) {
				List<Integer> tomato = queue.poll();
				for (int j = 0; j < 4; j++) {
					int ny = tomato.get(0) + dy[j]; //행
					int nx = tomato.get(1) + dx[j]; //열
					if (ny >= 0 && ny < N && nx >= 0 && nx < M && box[ny][nx] == 0) {
						box[ny][nx] = 1;
						dis[ny][nx] = dis[tomato.get(0)][tomato.get(1)] + 1;
						queue.offer(new ArrayList<>(Arrays.asList(ny, nx)));
					}
				}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		dis = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					queue.offer(new ArrayList<>(Arrays.asList(i, j)));					
				}
			}
		}
		
		BFS();
		boolean flag = true;
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					flag = false;
				}
			}
		}
		if (flag) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					answer = Math.max(answer, dis[i][j]);
				}
			}
			System.out.println(answer);
		} else {
			System.out.println(-1);			
		}
	}

}
