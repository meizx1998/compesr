import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SF2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Map<String,Integer> map=new LinkedHashMap<>();
            for (int i1 = 0; i1 < n; i1++) {
                String name = sc.next();
                int score = sc.nextInt();
               if (map.containsKey(name)){
                   map.put(name,map.get(name)+score);
               }
               else {
                   map.put(name,score);
               }
            }
            AtomicInteger maxScore= new AtomicInteger(Integer.MIN_VALUE);
            AtomicReference<String> name= new AtomicReference<>(" ");
            map.forEach((k,v)->{
                if (v> maxScore.get()){
                    name.set(k);
                    maxScore.set(v);
                }
            });
            System.out.println(name);
        }
    }
}
