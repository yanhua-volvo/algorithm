package leetbook.array;

/**
 * @author: WangYanHua
 * @date: 2023-02-27 21:27
 **/
public class CenterIndexOfArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 0, 3};

        System.out.println(centerIndexOfArray(array));
    }

    public static int centerIndexOfArray(int[] array) {
        int len = array.length;

        for (int i = 0; i < len; i++) {
            if (leftSum(array, i) == rightSum(array, i)) {
                return i;
            }
        }

        return -1;
    }

    public static int leftSum(int[] array, int index) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static int rightSum(int[] array, int index) {
        int sum = 0;
        for (int i = index + 1; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

}
