import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int a = sc.nextInt(); int b = sc.nextInt(); int c = sc.nextInt();
        int[] arr = {a,b,c};
        if(a==b && b==c) result = 10000+a*1000;
        else if(a==b) result = 1000+a*100;
        else if(a==c) result = 1000+a*100;
        else if(b==c) result = 1000+b*100;
        else result=Arrays.stream(arr).max().getAsInt()*100;
        System.out.println(result);
    }
}