package leetbook.sort;


import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author yh_wang
 * @date 2023-04-11
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {3,5,1,9,10,5,3};
        sort(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static int[] sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            solution(nums);
        }
        return nums;
    }


    public static void solution(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            int j = i + 1;
            if (nums[i] > nums[j]) {
                //交换
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
