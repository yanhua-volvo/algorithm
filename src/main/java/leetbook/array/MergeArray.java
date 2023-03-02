package leetbook.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: WangYanHua
 * @date: 2023-03-01 20:32
 **/
public class MergeArray {

    public static void main(String[] args) {
        int[][] intervals= {
            {1,3},
            {2,6},
            {8,10},
            {15,18}
        };
        int[][] merge = merge(intervals);

        System.out.println(Arrays.deepToString(merge));
        //[[1,3],[2,6],[8,10],[15,18]]
    }

    public static int[][] merge(int[][] intervals){
        //[[1,3],[2,5],[5.7],[8,9]] -> [[1,5],[5,7],[8,9]]
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> res = new ArrayList<>();
        int[] term = intervals[0];
        for(int i=1; i<intervals.length;i++){
            if(term[1] >= intervals[i][0]){
                term[1] = Math.max(term[1], intervals[i][1]);
            }else{
                res.add(term);
                term = intervals[i];
            }
        }
        res.add(term);
        return res.toArray(new int[res.size()][2]);

    }
}
