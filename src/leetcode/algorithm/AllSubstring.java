package leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class AllSubstring {
    public static void main(String[] args) {
        System.out.println(MySolution.substring("aac"));
    }
    //返回字符串s的所有字串
    static class MySolution {
        static List<String> res = new ArrayList<>();
        static public List<String> substring(String s) {
            StringBuilder sb = new StringBuilder();
            backtrack(sb,s,0);
            return res;
        }
        public static void backtrack(StringBuilder sb,String s,int i){
            if (i == s.length()){
                //去重
                if (!res.contains(sb.toString())){
                    String s1 = sb.toString();
                    res.add(s1);
                }
                return;
            }
            sb.append(s.charAt(i));
            backtrack(sb, s, i + 1);
            sb.delete(sb.length() - 1, sb.length());
            backtrack(sb, s, i + 1);
        }
    }
}
