package leetcode.algorithm;

public class IntArraySolution {

   public static void printIntArrays(int[][] intss){
       for (int[] ints : intss) {
           System.out.print("{");
           for (int i = 0; i < ints.length; i++) {
               String s = i == ints.length-1? ints[i]+"":ints[i]+",";
               System.out.print(s);
           }
           System.out.print("}");
           System.out.println();
       }
   }

}
