package leetbook.sort;


import java.util.Arrays;

/**
 * 归并排序
 *
 * @author yh_wang
 * @date 2023-04-12
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {1,5,3,9,8,5,4};

        sort(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums){
        merge_recursive(nums,0,nums.length-1);
    }

    public static void merge_recursive(int[] nums, int start,int end){
        if(start >= end){
            return;
        }
        int mid = start + (end-start)/2;
        merge_recursive(nums, start, mid);
        merge_recursive(nums, mid+1,end);

        //合并
        merge(nums,start,mid, end);
    }

    public static void merge(int[] nums, int begin, int mid, int end){
        int[] temp = new int[end-begin+1];
        int i = begin;
        int m = mid +1;
        int k =0;
        while(i <= mid && m<= end){
            if(nums[i]<= nums[m]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[m++];
            }
        }
        int start = i;
        int last = mid;
        if(m <= end){
            start = m;
            last = end;
        }

        while(start <= last){
            temp[k++] = nums[start++];
        }

        for(int n = 0; n< temp.length; n++){
            nums[n + begin] = temp[n];
        }
    }
}
