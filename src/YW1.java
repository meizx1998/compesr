public class YW1 {

    public boolean isValidBST(TreeNode root) {
       return isBst(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }

    public boolean isBst(TreeNode root,int max,int min){
        if (root==null){
            return true;
        }
        if (root.val<min||root.val>=max){
            return false;
        }
        return isBst(root.left, root.val, min) && isBst(root.right, max, root.val);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    public String longestPrefix (String s) {
        int length = s.length();
        for (int i = 1; i < length; i++) {

            System.out.println(s.substring(0,length-i));
            System.out.println(s.substring(i,length));
            if (s.substring(0,length-i).equals(s.substring(i,length))){
                System.out.println("true");
                return s.substring(0,length-1-i);
            }
        }
        return "";
    }

    public static void main(String[] args) {
       TreeNode treeNode=new TreeNode(1);
        String level = treeNode.longestPrefix("level");
        System.out.println(level);
    }
}