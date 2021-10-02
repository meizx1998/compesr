import java.util.Arrays;
import java.util.Scanner;

public class SC3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split("\\s+");
        StringBuilder sb=new StringBuilder();
        for (String s1 : split) {
            StringBuilder temp=new StringBuilder(s1);
            StringBuilder reverse = temp.reverse();
            sb.append(reverse);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);

    }
}
