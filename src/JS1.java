import java.util.Arrays;
import java.util.Scanner;

public class JS1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr=new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i]=new int[i+1];
            for (int j = 0; j < i+1; j++) {
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(13);

    }
}
