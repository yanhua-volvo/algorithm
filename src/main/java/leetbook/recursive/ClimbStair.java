package leetbook.recursive;


/**
 * 爬楼梯
 *
 * @author yh_wang
 * @date 2023-04-11
 */
public class ClimbStair {

    public static void main(String[] args) {
        System.out.println(solution(10));

    }


    /**
     * 解决方案
     *
     * @param n n
     * @return int
     */
    public static int solution(int n){
        if(n == 1){
            return 1;
        }
        if(n ==2){
            return 2;
        }
        return solution(n-1) + solution(n-2);
    }
}
