package leetcode.algorithm;
//中等
// 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
//
//通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
//C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//给你一个整数，将其转为罗马数字。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class _12IntToRoman {

    public static void main(String[] args) {
        //String s = intToRoman(459);
        String s1 = Solution.intToRoman(45);
        System.out.println(s1);
    }
    public static String intToRoman(int num) {
        ArrayList<ArrayList<String>> lists = new ArrayList<>();
        ArrayList<String> I = new ArrayList<>();
        ArrayList<String> X = new ArrayList<>();
        ArrayList<String> C = new ArrayList<>();
        I.addAll(Arrays.asList(new String[]{"I", "IV", "V", "IX"}));
        X.addAll(Arrays.asList(new String[]{"X", "XL", "L", "XC"}));
        C.addAll(Arrays.asList(new String[]{"C", "CD", "D", "CM"}));
        lists.add(I);
        lists.add(X);
        lists.add(C);
        String roman = "";
        int index =0;
        int i = num%10;
        while (i!=0){
            if(i<4){
                while (i>0){
                    roman+=lists.get(index).get(0);
                    i--;
                }
            }
            else if(i==4)
                roman+=lists.get(index).get(1);
            else if(i==5)
                roman+=lists.get(index).get(2);
            else if(i<9){
                roman+=lists.get(index).get(2);
                while (i>5){
                    roman+=lists.get(index).get(0);
                    i--;
                }
            }
            else
                roman+=lists.get(index).get(3);
            num/=10;
            i=num%10;
            index++;
        }
        return roman;
    }
    //方法一：模拟
    //思路
    //
    //根据罗马数字的唯一表示法，为了表示一个给定的整数
    //我们寻找不超过 num 的最大符号值，将 num 减去该符号值，然后继续寻找不超过num 的最大符号值，将该符号拼接在上一个找到的符号之后，
    // 循环直至 num 为 0。最后得到的字符串即为 num 的罗马数字表示。
    static class Solution {
        static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public static String intToRoman(int num) {
            StringBuffer roman = new StringBuffer();
            for (int i = 0; i < values.length; ++i) {
                int value = values[i];
                String symbol = symbols[i];
                while (num >= value) {
                    num -= value;
                    roman.append(symbol);
                }
                if (num == 0) {
                    break;
                }
            }
            return roman.toString();
        }
    }

}
