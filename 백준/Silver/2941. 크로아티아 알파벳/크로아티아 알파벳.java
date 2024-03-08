import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(String i : arr) {
			s = s.replace(i, "*");
		}
		System.out.println(s.length());
    }
}