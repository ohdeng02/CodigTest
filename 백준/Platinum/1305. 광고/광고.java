import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {	
	static int[] getLPS(String s) {
		int n = s.length();
		int leng=0;
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=0;
		}
		
		for(int i=1; i<n; i++) {
			while(s.charAt(i)!=s.charAt(leng) && leng>0) {
				leng = arr[leng-1];
			}
			if(s.charAt(i)==s.charAt(leng)) {
				arr[i] = ++leng;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int[] arr = getLPS(s);
		int lps = arr[arr.length-1];
		System.out.println(s.length()-lps);
	}
}
