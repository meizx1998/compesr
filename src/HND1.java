import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class HND1 {

    public int lengthOfLongestSubstring(String s) {
        // write code here
        char[] chars = s.toCharArray();
        int length=chars.length;
        Map<Character,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int max=0;
        for (j = 0; j < length; j++) {
            if (map.containsKey(chars[j])){
                i=Math.max(map.get(chars[j]),i);
            }
            map.put(chars[j],j);
            max=Math.max(max,j-i);
        }
        return max;
    }

    public boolean isValid (String s) {
        if (s.length()==0){
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for (char aChar : chars) {
            switch (aChar){
                case '{':
                    stack.push('{');
                    break;
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '}':
                    if (!stack.empty()&&stack.peek()=='{'){
                        stack.pop();
                    }
                    break;
                case ']':
                    if (!stack.empty()&&stack.peek()=='['){
                        stack.pop();
                    }
                    break;
                case ')':
                    if (!stack.empty()&&stack.peek()=='('){
                        stack.pop();
                    }
                    break;
            }

        }
        return stack.isEmpty();
    }
    public boolean isMatch (String s, String p) {
       return true;
    }
}
