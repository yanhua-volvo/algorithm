package leetbook.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author yh_wang
 * @date 2023-04-11
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {3,5,6,3,1,9};
        sort(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (nums[j] > value) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
    }
}
