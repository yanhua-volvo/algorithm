package leetbook.sort;


import java.util.Arrays;

/**
 * 快速排序
 *
 * @author yh_wang
 * @date 2023-04-12
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {1,5,3,9,8,5,4};
        sort(nums,0, nums.length-1);

        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int pivot = partition(nums, start, end);
        sort(nums,start,pivot-1);
        sort(nums, pivot+1, end);
    }

    public static int partition(int[] nums, int start, int end){
        int pivot = nums[end];
        int i=start;
        int j = start;
        for(;j<=end -1;j++){
            if(nums[j]< pivot){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i = i+1;
            }
        }

        int temp = nums[i];
        nums[i] = pivot;
        nums[end] = temp;

        return i;
    }


}
