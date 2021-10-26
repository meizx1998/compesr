import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class WM1 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public int numDistinct(String S, String T) {
        if (S.length() == 0 || T.length() == 0) {
            return 0;
        }
        char[] charsS = S.toCharArray();
        char[] charsT = T.toCharArray();
        int[] a = new int[S.length()];
        int sum = 1;
        for (int i = T.length() - 1; i >= 0; i--) {
            for (int j = S.length() - 1; j >= 0; j--) {
                int num = a[j];
                a[j] = charsT[i] == charsS[j] ? sum : 0;
                sum += num;
            }
            sum = 0;
        }
        for (int i : a) {
            sum += i;
        }
        return sum;
    }

    public void reorderList(ListNode head) {
        if (head==null||head.next==null){
            return;
        }
        ListNode p=head;
        ListNode q=head;
        ListNode top;
        ListNode middle;
        q=q.next.next;
        while (q!=null){
            p=p.next;
            if (q.next!=null){
                q=q.next.next;
            }
            else {
                break;
            }
        }
        middle=p.next;
        p.next=null;
        p=middle.next;
        middle.next=null;
        while (p!=null){
            q=p.next;
            p.next=middle;
            middle=p;
            p=q;
        }
        top=head;
        while (top!=null&&middle!=null){
            p=top.next;
            q=middle.next;
            top.next=middle;
            middle.next=p;
            top=p;
            middle=q;
        }
    }

    LinkedList<String> res=new LinkedList<>();
    StringBuilder sb=new StringBuilder();



    public ArrayList<String> getPermutation(String A) {
        int length = A.length();
        char[] chars = A.toCharArray();
        int[] arr=new int[length];
        Arrays.sort(chars);
        function(chars,length,arr);
        res.sort(Comparator.reverseOrder());
        ArrayList<String> ans = new ArrayList(res);
        return ans;
    }

    public void function(char[] chars,int n,int[] arr){
        if (sb.length()==n){
            res.add(sb.toString());
        }
        for (int i = 0; i < n; i++) {
            if (arr[i]==1){
                continue;
            }
            if (i!=0&&chars[i]==chars[i-1]&&arr[i-1]==0){
                continue;
            }
            sb.append(chars[i]);
            arr[i]=1;
            function(chars,n,arr);
            sb.deleteCharAt(sb.length()-1);
            arr[i]=0;
        }
    }

    public int reversePlus (int a, int b) {
       int tempA=a;
       int tempB=b;
       int newA=0;
       int newB=0;
       while (tempA!=0){
           int temp=tempA%10;
           newA=newA*10+temp;
           tempA=tempA/10;
       }
        while (tempB!=0){
            int temp=tempB%10;
            newB=newB*10+temp;
            tempB=tempB/10;
        }
        a=Math.max(newA,a);
        b=Math.max(newB,b);
        return a+b;
    }
}
