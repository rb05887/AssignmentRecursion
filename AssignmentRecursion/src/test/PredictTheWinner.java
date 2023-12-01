package test;
public class PredictTheWinner {
    public static void main(String[] args) {
        int[] nums1 = {1, 5, 2};
        System.out.println(predictTheWinner(nums1)); 

        int[] nums2 = {1, 5, 233, 7};
        System.out.println(predictTheWinner(nums2)); 
    }

    public static boolean predictTheWinner(int[] nums) {
        return canWin(nums, 0, nums.length - 1) >= 0;
    }

    private static int canWin(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int chooseStart = nums[start] - canWin(nums, start + 1, end);
        int chooseEnd = nums[end] - canWin(nums, start, end - 1);

        return Math.max(chooseStart, chooseEnd);
    }
}