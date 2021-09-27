import java.util.Scanner;

public class XF2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }

        int max=0;
        int lastMax=0;
        int last=arr[0];
        int maxIndex=0;
        for (int i = 0; i < n; i++) {
            if (arr[i]==last){
                max++;
            }
            else {
                if (max>lastMax){
                    lastMax=max;
                    maxIndex=i-1;
                }
                max=1;
            }
        }
        if (max>lastMax){
            lastMax=max;
            maxIndex=n-1;
        }

        //spread

        if (maxIndex+2<n&&arr[maxIndex]==arr[maxIndex+2]){
            lastMax++;
        }
        else {
            int index=maxIndex;
            while (index>1&&arr[index]==arr[maxIndex]){
                index--;
            }
            if (index!=1){
                if (arr[index-1]==arr[maxIndex]){
                    lastMax++;
                }
            }
        }

        System.out.println(lastMax);
    }
}
