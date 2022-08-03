package leetcode.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

public class _71SimplifyPath {
    public static void main(String[] args) {
        System.out.println(MySolution.simplifyPath("/a/v/b//..///c/xs/faf/../"));
        System.out.println(Solution.simplifyPath("/a/v/b///..//c/xs/faf/../"));
    }
    static class Solution {
        public static String simplifyPath(String path) {
            String[] names = path.split("/");
            Deque<String> stack = new ArrayDeque<String>();
            for (String name : names) {
                if ("..".equals(name)) {
                    if (!stack.isEmpty()) {
                        stack.pollLast();
                    }
                } else if (name.length() > 0 && !".".equals(name)) {
                    stack.offerLast(name);
                }
            }
            StringBuffer ans = new StringBuffer();
            if (stack.isEmpty()) {
                ans.append('/');
            } else {
                while (!stack.isEmpty()) {
                    ans.append('/');
                    ans.append(stack.pollFirst());
                }
            }
            return ans.toString();
        }
    }

    static class MySolution {
        public static String simplifyPath(String path) {
            if(path.charAt(0)!='/'){
                String s = "/";
                path = s.concat(path);
            }
            int length = path.length();
            String s = "/";
            int start = 0;
            int end = 0;
            for (int i = 1; i < length; i++) {
                if(path.charAt(i) == '.'){
                    if(i+1<length && path.charAt(i+1) == '.'){

                        i+=2;
                        //s返回上一級
                        int j = s.length()-2;
                        while (j>0 && s.charAt(j)!='/'){
                            s=s.substring(0,j);
                            j--;
                        }
                    }
//                    else if(i+1<length && path.charAt(i+1) == '/'){
//                        i++;
//                    }
                }
                else if(path.charAt(i)=='/'){
                    if(i+1<length && path.charAt(i+1) == '/'){
                        i++;
                    }
                    s+=path.charAt(i);
                }
                else {
                    s+=path.charAt(i);
                }
            }
            while (s.charAt(s.length()-1) == '/' && s.length()>1)
                s = s.substring(0,s.length()-1);
            return s;
        }
    }
}
