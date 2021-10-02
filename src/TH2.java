import java.util.Scanner;

public class TH2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m = sc.nextInt();//总算力
        int w = sc.nextInt();//任务数
        int[] value=new int[w+1];
        int[] consume=new int[w+1];
        int[][] dp=new int[m+1][m+1];
        for (int i = 1; i <= w; i++) {
            consume[i]=sc.nextInt();
            value[i]=sc.nextInt();
        }
        for (int i = 1; i <=w; i++) {
            for (int j =1; j <=m ; j++) {
               if (j>=consume[i]){
                   dp[i][j]=Math.max(dp[i-1][j-consume[i]]+value[i],dp[i-1][j]);
               }
               else {
                   dp[i][j]=dp[i-1][j];
               }
            }
        }
        System.out.println(dp[w][m]);
    }
}
