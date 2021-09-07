package cyc;


public class Solution {

    /**
     * 数组中重复的数字
     * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
     * 请找出数组中任意一个重复的数字。
     * <p>
     * 要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
     */
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; ) {

            int cur = nums[i];

            if (cur != i) {
                if (cur == nums[cur]) return cur;
                nums[i] = nums[cur];
                nums[cur] = cur;
            } else i++;

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findRepeatNumber(new int[]{4, 3, 1, 0, 2, 1}));
    }


}
