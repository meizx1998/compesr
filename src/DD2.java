import java.util.Scanner;
public class DD2{
    public static int strDeduplication(String str){
        char[] chars = str.toCharArray();
        int[] arr=new int[1024];
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i]]++;
        }

        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=Math.min(2,arr[i]);
        }
        return sum;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            String str = in.next();
            System.out.println(strDeduplication(str));
        }
    }
}