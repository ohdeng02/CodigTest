import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        
        int res1 = a*(b%10); b/=10;
        int res2 = a*(b%10); b/=10;
        int res3 = a*b;
        builder.append(Integer.toString(res1)+"\n"+Integer.toString(res2)+"\n"+Integer.toString(res3)+"\n");
        builder.append(Integer.toString(res1+res2*10+res3*100)+"\n");
        bw.write(builder.toString()); bw.flush();
    }
}