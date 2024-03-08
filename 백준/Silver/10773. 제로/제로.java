import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> st = new Stack<>();
		
		int num = Integer.parseInt(br.readLine());
		for(int i=0; i<num; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) st.pop();
			else {
				st.add(n);
			}
		}
		int sum = 0;
		for(int i=0; i<st.size(); i++) {
			sum += st.get(i);
		}
		bw.write(Integer.toString(sum));
		bw.flush();
	}
}