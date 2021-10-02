import java.util.Scanner;

public class SC1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long x = sc.nextInt();
        long y = sc.nextInt();
        long m = sc.nextInt();
        if (x>=m||y>=m){
            System.out.println(0);
        }
        else if (x<=0&&y<=0){
            System.out.println(-1);
        }

        else {
            int count=0;
            while (x<m&&y<m){
                count++;
                long sum=x+y;
                if (x<y){
                    x=sum;
                }
                else {
                    y=sum;
                }
            }
            System.out.println(count);
        }
    }
}
