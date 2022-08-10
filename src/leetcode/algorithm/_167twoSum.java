package leetcode.algorithm;

public class _167twoSum {
    public static void main(String[] args) {
        int[] ints = MySolution.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i : ints) {
            System.out.println(i);
        }
    }
    static class MySolution {
        public static int[] twoSum(int[] numbers, int target) {
            int low = 0, high = numbers.length - 1;
            while (low < high) {
                int sum = numbers[low] + numbers[high];
                if (sum == target) {
                    return new int[]{low + 1, high + 1};
                } else if (sum < target) {
                    ++low;
                } else {
                    --high;
                }
            }
            return new int[]{-1, -1};
        }
    }

}
