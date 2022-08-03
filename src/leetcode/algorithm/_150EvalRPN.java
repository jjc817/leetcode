package leetcode.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class _150EvalRPN {
    public static void main(String[] args) {
        System.out.println(MySolution.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
   static class MySolution {
        public static int evalRPN(String[] tokens) {
            Deque<Integer> number = new ArrayDeque<>();
            int num = 0;
            for (String token : tokens) {
                if((token.charAt(0)<='9' && token.charAt(0)>='0')||(token.charAt(0) == '-' && token.length()>1)){
                    number.addFirst(Integer.parseInt(token));
                }else {
                    Integer n = number.pop();
                    Integer m = number.pop();
                    if(token=="+"){
                        num = n + m;
                        number.addFirst(num);
                    }else if(token=="*"){
                        num = n * m;
                        number.addFirst(num);
                    }else if(token=="/"){
                        num = m / n;
                        number.addFirst(num);
                    }else if(token=="-"){
                        num = m - n;
                        number.addFirst(num);
                    }
                }
            }
            return num;
        }
    }
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new LinkedList<Integer>();
            int n = tokens.length;
            for (int i = 0; i < n; i++) {
                String token = tokens[i];
                if (isNumber(token)) {
                    stack.push(Integer.parseInt(token));
                } else {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    switch (token) {
                        case "+":
                            stack.push(num1 + num2);
                            break;
                        case "-":
                            stack.push(num1 - num2);
                            break;
                        case "*":
                            stack.push(num1 * num2);
                            break;
                        case "/":
                            stack.push(num1 / num2);
                            break;
                        default:
                    }
                }
            }
            return stack.pop();
        }

        public boolean isNumber(String token) {
            return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
        }
    }
}
