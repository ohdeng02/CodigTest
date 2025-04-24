import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static boolean[] prime = new boolean[246913]; 
	public static int[] count_arr = new int[246913];

	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		get_prime();	// 소수를 얻는 메소드 실행
		get_count();	// 소수의 개수가 저장된 배열을 얻는 메소드 실행
		StringBuilder sb = new StringBuilder();
 
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;	// n 이 0 일경우 종료
 
			sb.append(count_arr[2 * n] - count_arr[n]).append('\n');
		}
		System.out.print(sb);
	}
	
	public static void get_prime() {
		// 0 과 1 은 소수가 아니므로 ture
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
    
	public static void get_count() {
		int count = 0;
		for(int i = 2; i < prime.length; i++) {
			if(!prime[i]) count++;	// 소수일 경우 count를 증가시킨다
			count_arr[i] = count;	
		}
	}
 
 
}