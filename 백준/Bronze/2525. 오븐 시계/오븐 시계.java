import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		int h = sc.nextInt(); int m = sc.nextInt();
		int time = sc.nextInt();
		h = ((h*60+m)+time)/60; m = ((h*60+m)+time)%60;
		if(h>23) h-=24;
		System.out.println(h+" "+m);
    }
}