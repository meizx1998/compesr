import java.util.HashSet;
import java.util.Scanner;

public class DD1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String[] s3 = s1.split(",");
        String[] s4 = s2.split(",");
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        for (int i = 0; i < s3.length; i++) {
            try {
                int i1 = Integer.parseInt(s3[i]);
                hashSet1.add(i1);
            } catch (Exception e) {

            }
        }
        for (int i = 0; i < s4.length; i++) {
            try {
                int i1 = Integer.parseInt(s4[i]);
                hashSet2.add(i1);
            } catch (Exception e) {

            }
        }
        HashSet<Integer> result=new HashSet<>();

        for (Integer integer : hashSet1) {
            if (hashSet2.contains(integer)){
                result.add(integer);
            }
        }
        System.out.println(result.size());
    }
}
