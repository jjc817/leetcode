package leetcode.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class _179largestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{10, 2}));
    }

    public static String largestNumber(int[] nums) {
        PriorityQueue<String> heap = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));
        for(int x: nums)
            heap.offer(String.valueOf(x));
        String res = "";
        while(heap.size() > 0)
            res += heap.poll();
        if(res.charAt(0) == '0')
            return "0";
        return res;
    }
    public static String largestNumber2(int[] nums) {
        String str = Arrays.stream(Arrays.stream(nums).boxed().toArray()).map(String::valueOf).sorted((x, y) -> (y + x).compareTo(x + y)).collect(Collectors.joining(""));
        return str.charAt(0) == '0' ? "0" : str;
    }
}
