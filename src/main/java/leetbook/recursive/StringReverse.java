package leetbook.recursive;

/**
 * 字符串反转
 *
 * @author yh_wang
 * @date 2023-04-11
 */
public class StringReverse {

    public static void main(String[] args) {
        String world = "hello";

        System.out.println(reverse(world));
    }


    /**
     * 反向
     *
     * @param source 源
     * @return {@link String}
     */
    public static String reverse(String source) {

        int i = 0;
        if (source.equals("")) {
            return source;
        } else {
            i++;
            if (i <= source.length()) {
                String subString ="";
                if(i != source.length()){
                    subString = source.substring(i);
                }
                String subSolution = reverse(subString);
                return subSolution + source.charAt(0);
            }

        }
        return "";

    }
}
