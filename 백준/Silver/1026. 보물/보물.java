import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arrA = new int[N];
        Integer [] arrB = new Integer[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arrA[i] = Integer.parseInt(st1.nextToken());
            arrB[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arrA);
		Arrays.sort(arrB, Collections.reverseOrder());

        int result = 0;
        for(int i=0; i<N; i++){
            result += arrA[i]*arrB[i];
        }
        System.out.println(result);
    }
}