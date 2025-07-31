import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n,i,m,t;
		n = Integer.parseInt(br.readLine());
		boolean[] chk = new boolean[n];
		Stack<Integer> stack = new Stack<>(); 
		String str = br.readLine();
		for(i=0;i<n;i++) {
			if(str.charAt(i)=='(') {
				stack.add(i);
			}else {
				if(!stack.isEmpty()) {
					chk[stack.pop()] = true;
					chk[i] = true;
				}
			}
		}
		m = t = 0;
		for(i=0;i<n;i++) {
			if(chk[i]) {
				t++;
				m = Math.max(m, t);
			}else {
				t = 0;
			}
		}
		System.out.println(m);
	}
}