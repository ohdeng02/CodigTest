import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		long [] Dp = new long[N+2];
		Dp[1]=1;
		Dp[2]=1;
		for(int i=3;i<=N;i++) {
			Dp[i]=Dp[i-1]+Dp[i-2];
		}
		System.out.println(Dp[N]);
		}
	}