import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		int no = 1;//출력할 때 number 
		while(true) {

			String str = br.readLine();
			
			if(str.contains("-")) break;
			
			int n = str.length();
			int t = 0;
			
			for(int i = 0; i < n; i++) {
				char tmp = str.charAt(i);
				if(tmp == '{')
					stack.push(tmp);
				else {
					if(stack.isEmpty()) {
						stack.push('{');
						t++;
					}
					else
						stack.pop();
				}
			}
			t += stack.size() / 2;
			sb.append((no++) + ". " + t + "\n");
			stack.clear();
		}
		System.out.println(sb.toString());
		br.close();
	}

}