import java.util.Scanner;

public class Zhanquan {
    public static int  kSum(int A[], int k, int target) {
        int n = A.length;
        int[][][] f = new int[n + 1][k + 1][target + 1];
        for (int i = 0; i < n + 1; i++) {
            f[i][0][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    if (t >= A[i - 1]) {
                        f[i][j][t] = f[i - 1][j - 1][t - A[i - 1]];
                    }
                    f[i][j][t] += f[i - 1][j][t];
                } // for t
            } // for j
        } // for i
        return f[n][k][target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String source = sc.nextLine();
        String str[] = source.split(",");
        int array[] = new int[str.length];
        for(int i=0;i<str.length;i++)
            array[i]=Integer.parseInt(str[i]);
        int k = Integer.parseInt(sc.nextLine());
        int target = Integer.parseInt(sc.nextLine());
        int out = kSum(array,k,target);
        System.out.println(out);
    }

}
