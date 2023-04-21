package leetbook.search;

/**
 * @author: yh_wang
 * @date: 2023-04-21 14:44
 **/
public class MoreBS {

    public static void main(String[] args) {
        int[] nums = {1, 4, 4, 5, 7, 10};
        System.out.println(solution(nums, 0, nums.length - 1, 4));
        System.out.println(MoreSolution(nums,0, nums.length-1, 6));
    }


    /**
     * 解决方案: 查找第一个值等于给定值的元素
     *
     * @return int
     */
    public static int solution(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 更多解决方案: 查找第一个大于等于给定值的元素
     *
     * @param nums   全国矿工工会
     * @param low    低
     * @param high   高
     * @param target 目标
     * @return int
     */
    public static int MoreSolution(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] >= target){
               if(mid == 0 || nums[mid -1] < target){
                   return mid;
               }else{
                   high = mid -1;
               }
            }else{
                low = mid +1;
            }
        }
        return -1;
    }
}
