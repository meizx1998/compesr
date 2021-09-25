import java.util.Arrays;

public class M2 {

    public static void main(String[] args) {
        int[] arr=new int[]{1,4,5,7,8,11,11,11,13,13};
        int i = find(arr, 13);
        System.out.println(i);
    }

    public static int find(int[] arr,int target){
        Arrays.sort(arr);
        int length = arr.length;
        int left=0;
        int right=length-1;
        int mid=(left+right)/2;
        while (left-right<=0){
            mid=(left+right)/2;
            if (arr[mid]>target){
                right=mid-1;
            }
            else if(arr[mid]<target){
                left=mid+1;
            }
            else {


                while (mid<length-1&&arr[mid]==target){
                    mid++;
                }
                return mid-1;
            }

        }
        return -1;

    }
}
