import java.util.HashSet;
import java.util.Scanner;

public class SLL1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String numsString = sc.nextLine();
        String[] s = numsString.split(" ");
        String zhuyu = sc.nextLine();
        String weiyu = sc.nextLine();
        String bingyu = sc.nextLine();
        String[] zhu = zhuyu.split(" ");
        String[] wei = weiyu.split(" ");
        String[] bin = bingyu.split(" ");

        HashSet<String> zhus=new HashSet<>();
        for (String s1 : zhu) {
            zhus.add(s1);
        }
        HashSet<String> weis=new HashSet<>();
        for (String s1 : wei) {
            weis.add(s1);
        }

        HashSet<String> bins=new HashSet<>();
        for (String s1 : bin) {
            bins.add(s1);
        }
        String times = sc.nextLine();
        int time=Integer.parseInt(times);
        for (int i = 0; i < time; i++) {
            int z=0,w=0,b=0;
            String phar = sc.nextLine();
            String[] s1 = phar.split(" ");
            for (String s2 : s1) {
                if (zhus.contains(s2)){
                    z++;
                }
                else if (bins.contains(s2)){
                    b++;
                }
                else if (weis.contains(s2)){
                    w++;
                }
            }
            if (z!=0&&w==1){
                if (zhus.contains(s1[0])){
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
            else {
                System.out.println("NO");
            }

        }
    }
}
