
class Solution {
    public static boolean help(int[] nums, int i) {
        if (i == nums.length - 1) {
            return true;
        }
        if (i >= nums.length || nums[i] == 0)
            return false;

        return help(nums, i + nums[i]);
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 5, 4, 3, 2, 0, 2, 10, 9, 8, 7, 6, 5, 4, 3, 2, 0, 1, 0 };
        System.out.println(help(nums, 0));
    }

}