package leetbook.array;

/**
 * @author: WangYanHua
 * @date: 2023-02-28 14:03
 **/
public class SelectAndInsert {

    public static void main(String[] args) {

        int[] array = {1, 3, 5, 6};
        System.out.println(findAndInsert(array, 5));
    }

    public static int findAndInsert(int[] array, int num) {
        int first = 0, last = array.length - 1;
        int mid = (first + last) / 2;
        while (first <= last) {
            if (array[mid] < num) {
                first = mid + 1;
            } else if (array[mid] > num) {
                last = mid - 1;
            } else {
                return mid;
            }
            mid = (first + last) / 2;
        }
        return first;
    }
}
