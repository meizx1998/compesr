import java.util.Scanner;

public class SF1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt();
            int n2=n/a+(n%a==0?0:1);
            int m2=m/a+(m%a==0?0:1);
            System.out.println(n2*m2);
        }
    }
}
