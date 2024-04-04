import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    static int N;
    static int[] board;
    
    static boolean isPromising(int idx){
        for(int i = 0; i < idx; i++){
            if(board[i] == board[idx] || idx - i == Math.abs(board[idx]-board[i])){
                return false;
            }
        }
        return true;
    }

    static void nqueen(int idx){
        if(idx == N){
            cnt++;
            return;
        }
        
        for(int i = 0; i < N; i++){
            board[idx] = i;
            if(isPromising(idx)){ //해당 행에서 해당 열에 놓는게 유망한 자리인지 확인. 유망하지 않으면 다음 열로 넘어감
                nqueen(idx + 1);
            }
        }
    } 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        
        nqueen(0);
        System.out.println(cnt);
    }
}
