import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class YY1 {
    public static void main(String[] args) {
        System.out.println(seriesnum(new int[]{4,6,7,8,9}));
    }



    public static boolean seriesnum (int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        boolean hasEight=false;
        for (int num : nums) {
            if (num==8){
                hasEight=true;
                continue;
            }
            list.add(num);
        }

        list.sort(Comparator.comparingInt(a -> a));

        int current=list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)==current+1){
                current++;
            }
            else {
                if (hasEight){
                    current++;
                    hasEight=false;
                    i--;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }

    public int[] getSpacialNum (int num) {
        int[] arr=new int[]{10,25,19,37,75,65,27,29,16,9,5,1};
        ArrayList<Integer> res=new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            for (int j = i+1; j <12 ; j++) {
                if (Math.abs(arr[i]-arr[j])==num){
                    res.add(arr[i]+arr[j]);
                }
            }
        }
        if (res.size()==0){
            return new int[]{0};
        }
        else {
            int[] re=new int[res.size()];
            res.sort(Comparator.comparingInt(a -> a));
            for (int i = 0; i < res.size(); i++) {
                re[i]=res.get(i);
            }
            return re;
        }

    }
}
