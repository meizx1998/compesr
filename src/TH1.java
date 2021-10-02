public class TH1 {

    public static void main(String[] args) {

    }

    public int countTiger (int month) {

        if (month==1||month==2){
            return 2;
        }
        int first=2,second =2,third=0;
        for (int i = 3; i <=month ; i++) {
            third=first+second;
            first=second;
            second=third;
        }
        return third;
    }

    public int[] duplicateZeros (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0){
                for (int j = arr.length-1; j >i; j--) {
                    arr[j]=arr[j-1];
                }
                i++;
            }
        }
        return arr;
    }
}
