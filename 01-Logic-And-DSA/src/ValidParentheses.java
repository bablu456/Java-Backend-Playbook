import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args){
        String input = "{[()]}";
        String input2 = "{[(])}";

        System.out.println(input+" is valid? "+ isValid(input));
        System.out.println(input2+ " is valid?"+isValid(input2));
    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()) return false;

                char top = stack.pop();

                if(c == ')' && top != '(') return false;
                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
