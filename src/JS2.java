import java.util.ArrayList;
import java.util.Scanner;

public class JS2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int max=0;
        ArrayList<Item> list =new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a=i;
            for (int j = i+1; j <n ; j++) {
                if (arr[a]<arr[j]);
                list.add(new Item(a,j,-1));
            }
        }
        for (Item item : list) {
           for (int i=item.b+1;i<n;i++){
               if (arr[i]>arr[item.b]){
                   max=Math.max(max,arr[item.a]+arr[item.b]+arr[i]);
               }
           }
        }
        System.out.println(max);
    }

}
class Item{
    int a;
    int b;
    int c;

    public Item(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}