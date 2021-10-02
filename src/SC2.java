import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class SC2 {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        ArrayList<Item> list=new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='('){
                stack.push(i);
            }
            else if (chars[i]==')'){
                Integer left = stack.pop();
                list.add(new Item(left,i));
            }
        }
        list.sort(Comparator.comparingInt(item -> item.left));
        System.out.println(list.size());
        for (Item item : list) {
            System.out.println(item.left);
            System.out.println(item.right);
        }

    }

    static class Item{
        int left;
        int right;

        public Item(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}

