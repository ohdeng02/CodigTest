import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
 
		
		ArrayDeque<Integer> deque;
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		
		while(T --> 0) {
			
			String command = br.readLine();	// 문제에서 p에 해당하는 명령어
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[],");
			
			deque = new ArrayDeque<Integer>();
			
			// 덱에 배열 원소를 넣어준다.
			for(int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			AC(command, deque);
		}
		
		System.out.println(sb);
		
	}
	
	public static void AC(String command, ArrayDeque<Integer> deque) {
		
		boolean isRight = true;
		
		for(char cmd : command.toCharArray()) {
			
			if(cmd == 'R') {
				isRight = !isRight;	// 방향을 바꿔준다.
				continue;
			}
			
			if(isRight) {
				
				if(deque.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
				
			}
			else {
				if(deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}	
			}
		}
		
		makePrintString(deque, isRight);
		
	}
	
	public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {
		
		sb.append('[');	// 여는 대괄호 먼저 StringBuilder에 저장
		
		if(deque.size() > 0) {	//만약 출력 할 원소가 한 개 이상일 경우
			
			if(isRight) {	// 정방향일경우 
				
				sb.append(deque.pollFirst());	// 먼저 첫 번째 원소를 넘겨준다.
				
				// 그 다음 원소부터 반점을 먼저 넘겨준 후 덱의 원소를 하나씩 뽑아 넘긴다. 
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}
			else {	// 역방향일경우 
				sb.append(deque.pollLast());	// 먼저 뒤에서부터 첫 번째 원소를 넘겨준다.
				
				// 그 다음 원소부터 반점을 먼저 넘겨준 후 덱의 원소를 뒤에서부터 하나씩 뽑아 넘긴다. 
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}
		
		sb.append(']').append('\n');	// 닫는 대괄호 및 개행으로 마무리
	}
}