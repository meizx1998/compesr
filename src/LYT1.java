import java.util.*;


   class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }


public class LYT1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类 链表
     * @param k int整型 
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
       ListNode ans=head;
        for (int i = 0; i < k - 1; i++) {
            ans=ans.next;
        }
        ListNode start=head;
        ListNode end=head;
        ListNode tmp=new ListNode(0);
        while (end!=null){
            end=start;
            for (int i = 0; i < k; i++) {
                if (end==null)return ans;
                end=end.next;
            }
            tmp=end;
            reverse(start,end,k);
            start=tmp;
        }
        return ans;
    }

    public void reverse(ListNode node1,ListNode node2,int k ){
        ListNode pre=null;
        ListNode cur=node1;
        ListNode next=node1;
        while (next!=node2){
            next=next.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        ListNode tmp=node2;
        for (int i = 0; i < k - 1; i++) {
            if (tmp==null)break;
            tmp=tmp.next;
        }
        if (tmp==null) node1.next=node2;
        else node1.next=tmp;
    }
    public int climbStairs (int n) {
      if (n==1||n==2){
          return n;
      }
      int n1=1;
      int n2=2;
        for (int i = 3; i <=n; i++) {
            int temp=n2;
            n2=n1+n2;
            n1=temp;
        }
        return n2;
    }
    public boolean find (int[][] arr, int target) {
        if (arr==null||arr.length==0||arr[0].length==0){
            return false;
        }
        int m=0;
        int n=arr.length-1;
        while (m<arr.length&&n>=0){
            if (arr[m][n]==target){
                return true;
            }
            if (arr[n][m]>target)n--;
            else m++;
        }
        return false;
    }

    int int_sqrt(int x) {
        if(x<=1){
            return x;
        }
        double r=x;
        double c=x;
        while (true){
            double d=(r+c/r)/2;
            if (Math.abs(r-d)<1e-7){
                return (int)r;
            }
            r=d;
        }
    }

    public int[] bubbleSort (int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j]>array[i]){
                    int temp=array[j];
                    array[j]=array[i];
                    array[i]=temp;

                }
            }
        }
        return array;
    }

    public boolean powerOf2 (int i) {
        return (i&(i-1))==0;
    }

    public boolean powerOf4 (int i) {
        return ((i&(i-1))==0&&i-1>=0&&(i&0x55555555)!=0);
    }

    public String spiralMatrix (int[][] matrix) {
      int m=matrix.length;
      int n=matrix[0].length;
      int up=0;
      int down=m-1;
      int left=0;
      int right=n-1;
      StringBuilder sb=new StringBuilder();
      while(true){
          for (int i=left;i<=right;i++){
              sb.append(matrix[up][i]+" ");

          }
          if (++up>down){
              break;
          }
          for (int i = up; i <=down ; i++) {
              sb.append(matrix[i][right]+" ");

          }
          if (left>--right){
              break;
          }
          for (int i = right; i >=left ; i--) {
              sb.append(matrix[down][i]+" ");

          }
          if (up>--down){
              break;
          }
          for (int i = down; i >=up ; i--) {
              sb.append(matrix[i][left]+" ");

          }
          if (++left>right)
              break;
      }
      sb.deleteCharAt(sb.length());
      return sb.toString();
    }
}