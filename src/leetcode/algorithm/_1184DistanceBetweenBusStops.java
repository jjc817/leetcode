package leetcode.algorithm;

import java.util.concurrent.ConcurrentHashMap;

//easy
public class _1184DistanceBetweenBusStops {
    public static void main(String[] args) {
        int[] ints = {1,2,3,4};
        int distance = MySolution.distanceBetweenBusStops(ints, 0, 2);
        System.out.println(distance);

    }
    static class MySolution {
        static public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            if (start>destination) {
                int temp = start;
                start = destination;
                destination = temp;
            }
            int left = start;
            int shunDistance=0;
            int niDistance=0;
            int right = destination;
            while(left<right){
                shunDistance+=distance[left];
                left++;
            }
            left=start;right=destination;
            while (left!=right){
                if (right>=distance.length) {
                    right=0;
                    continue;
                }
                niDistance+=distance[right];
                right++;
            }
            if (niDistance>shunDistance) {
                return shunDistance;
            }
            return niDistance;
        }
    }
    static class Solution {
        static public int distanceBetweenBusStops(int[] distance, int start, int destination) {
            if (start > destination) {
                int temp = start;
                start = destination;
                destination = temp;
            }
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < distance.length; i++) {
                if (i >= start && i < destination) {
                    sum1 += distance[i];
                } else {
                    sum2 += distance[i];
                }
            }
            return Math.min(sum1, sum2);
        }
    }
}
