import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class DXM3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String b = sc.nextLine();
        char[] sChars = s.toCharArray();
        char[] bChars = b.toCharArray();
        HashMap<Character, Integer> bmap = new HashMap<>();
        for (char bChar : bChars) {
            if (bmap.get(bChar) == null) {
                bmap.put(bChar, 1);
            } else {
                bmap.put(bChar, bmap.get(bChar) + 1);
            }
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (char sChar : sChars) {
            if (sMap.get(sChar) == null) {
                sMap.put(sChar, 1);
            } else {
                sMap.put(sChar, sMap.get(sChar) + 1);
            }
        }
        AtomicInteger maxCount = new AtomicInteger(Integer.MAX_VALUE);
        sMap.forEach((k, v) -> {
            Integer integer = bmap.get(k);
            if (integer==null){
                maxCount.set(0);
            }
            else {
                int temp=integer/v;
                maxCount.set(Math.min(temp,maxCount.get()));
            }
        });

        int max = maxCount.get();
        AtomicInteger cate= new AtomicInteger();
        bmap.forEach((k,v)->{
            if (sMap.get(k)==null){
                cate.getAndIncrement();
            }
            else
            if (v-max*sMap.get(k)>0){
                cate.getAndIncrement();
            }
        });
        int categ = cate.get();
        System.out.println(max+" "+categ);


    }
}
