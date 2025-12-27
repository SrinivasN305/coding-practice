package com.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis
{

    public static void main(String args[]) {
        String s = "([{}])";
        boolean b = isValidBruteForce(s);
        System.out.println(b);

        boolean b1 = isValidUsingStack(s);
        System.out.println(b1);
    }

    private static boolean isValidUsingStack(String s) {

        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        for (Character c : s.toCharArray()){
            if(map.containsKey(c)){
                if(!stack.isEmpty() && stack.peek() == map.get(c) ){
                    stack.pop();
                }else{

                    return false;
                }
            }else{
                stack.push(c);

            }
        }

        return stack.isEmpty();
    }

    private static boolean isValidBruteForce(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }
}
