import java.util.*;


public class W1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 写出返回最小砝码所需数量的实现代码
     * @param weights int整型一维数组 输入任意砝码数组
     * @param total int整型 目标值
     * @return int整型
     */
    public int weight (int[] weights, int total) {
        Arrays.sort(weights);
        int count=0;
        int weight=0;
        boolean flag=false;
        for (int i = weights.length-1; i >=0; i--) {
            if (flag){
                weight-=weights[i+1];
                count--;
            }
            flag=true;
            while (weight<total){
                weight+=weights[i];
                count++;
            }
            if (weight==total){
                break;
            }
        }
        if (weight==total){
            return count;
        }
        else {
            return -1;
        }
    }

    public int[] rec (int[][] results) {
        TreeSet<Integer> set=new TreeSet<>();
        for (int[] result : results) {
            for (int i : result) {
                set.add(i);
            }
        }
        int[] rec=new int[set.size()];
        int i=set.size()-1;
        for (Integer integer : set) {
            rec[i]=integer;
            i--;
        }
        return rec;
    }

    public boolean[] pathAvailable (int[][] matrix, int[][] starts, int[][] ends) {
       int count=0;
       boolean[] pathAva=new boolean[starts.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                function(matrix,count+2,i,j);
                count++;
            }
        }
        for (int i = 0; i < starts.length; i++) {
            if (matrix[starts[i][0]][starts[i][1]]==0||matrix[ends[i][0]][ends[i][1]]==0){
                pathAva[i]=false;
            }
            else {
                pathAva[i]=matrix[starts[i][0]][starts[i][1]]==matrix[ends[i][0]][ends[i][1]];
            }
        }

        System.out.println(matrix);
        return pathAva;
    }

    private void function(int[][] matrix, int count, int i, int j) {
        if (i<0||i>=matrix.length||j<0||j>=matrix[i].length||matrix[i][j]!=1){
            return;
        }

        matrix[i][j]=count;
        function(matrix,count,i+1,j);
        function(matrix,count,i-1,j);
        function(matrix,count,i,j+1);
        function(matrix,count,i,j-1);

    }

}