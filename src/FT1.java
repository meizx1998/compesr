import java.util.PriorityQueue;

public class FT1 {

    public int[] findTopKinTwoSortedArray (int[] arr1, int[] arr2, int k) {
        k=Math.min(k,arr1.length*arr2.length);
        int[] res=new int[k];
        int index=0;
        PriorityQueue<Node> maxHeap=new PriorityQueue<FT1.Node>((o1, o2)->
            o2.sum-o1.sum
        );
        boolean[][] visited=new boolean[arr1.length][arr2.length];
        int x=arr1.length-1;
        int y=arr2.length-1;
        maxHeap.add(new Node(x,y,arr1[x]+arr2[y]));
        visited[x][y]=true;
        while (index!=k){
            Node poll = maxHeap.poll();
            if (poll==null){
                break;
            }
            res[index]=poll.sum;
            x=poll.x;
            y=poll.y;
            if (x>=1&&!visited[x-1][y]){
                visited[x-1][y]=true;
                maxHeap.add(new Node(x-1,y,arr1[x-1]+arr2[y]));
            }
            if (y>=1&&!visited[x][y-1]){
                visited[x][y-1]=true;
                maxHeap.add(new Node(x,y-1,arr1[x]+arr2[y-1]));
            }
            index++;
        }
        return res;
    }


    class Node{
        int x;
        int y;
        int sum;

        public Node(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    public int solve (int n, int k) {
       if (n<1||k<1){
           return 0;
       }

       int[][] dp=new int[n+1][k+1];
        for (int i = 1; i < dp.length; ++i) {
            dp[i][1]=i;
        }
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 2; j <=k ; ++j) {
                int min=Integer.MAX_VALUE;
                for (int l = 1; l < i+1 ; l++) {
                    min=Math.min(min,Math.max(dp[l-1][j-1],dp[i-l][j]));
                }
                dp[i][j]=min+1;
            }
        }
        return dp[n][k];
    }

    public int sort (int target, int[] nums) {
      int low=0;
     int n=nums.length;
      int high=n-1;
      while (low<=high){
          int mid=low+(high-low)/2;
          if (nums[mid]<target){
              low=mid+1;
          }
          else{
              high=mid-1;
          }
      }
      return low;

    }
}
