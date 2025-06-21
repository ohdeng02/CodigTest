import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());        
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            sb.append(upperbound(nums, n) - lowerbound(nums, n)).append(" ");
        }
        
        System.out.println(sb);
    }

    static int lowerbound(int[] arr, int key) {
        int lt = 0, rt = arr.length;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (key <= arr[mid]) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }
        return lt;
    }

    static int upperbound(int[] arr, int key) {
        int lt = 0, rt = arr.length;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (key < arr[mid]) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }
        return lt;
    }
}