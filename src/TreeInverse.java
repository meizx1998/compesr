import java.util.Stack;

public class TreeInverse {

    public Node inverse(Node root){
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            Node left = node.left;
            node.left=node.right;
            node.right=left;

            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.left!=null){
                stack.push(node.right);
            }
        }

        return root;

    }
}

class Node{
    int val;
    Node left;
    Node right;
}
