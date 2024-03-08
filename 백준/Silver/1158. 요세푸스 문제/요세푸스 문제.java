import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); int k = sc.nextInt();
		
		List<Integer> result = new ArrayList<>();
		List<Integer> arr = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			arr.add(i);
		}
		int idx = k-1;
		while(true) {
			result.add(arr.get(idx));
			arr.remove(idx);
			int len = arr.size();
			if(len==0) break;
			idx = (idx+k-1)%len;
		}
		String re = "";
		re+="<";
		for(int i=0; i<result.size(); i++) {
			re+=result.get(i)+", ";
		}
		re = re.substring(0, re.length()-2)+">";
		System.out.println(re);
	}

}
