package leetbook.search;


/**
 * 二分查找
 *
 * @author yh_wang
 * @date 2023-04-17
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {1,4,6,9,18,20,44};

        System.out.println(solution(nums,0, nums.length-1, 9));

        System.out.println(recursiveSolution(nums, 0, nums.length-1, 9));

    }

    /**
     * 解决方案
     *
     * @param nums   数组
     * @param start  开始
     * @param end    结束
     * @param target 目标
     * @return int
     */
    public static int solution(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + ((end - start) >> 1);
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid -1;
            }else{
                end = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 递归解决方案
     *
     * @param nums   数组
     * @param low    低
     * @param high   高
     * @param target 目标
     * @return int
     */
    public static int recursiveSolution(int[] nums, int low, int high, int target){

        if(low > high){
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] > target){
            return recursiveSolution(nums, low, mid -1, target);
        }else{
            return recursiveSolution(nums,mid +1, high, target);
        }
    }

}
