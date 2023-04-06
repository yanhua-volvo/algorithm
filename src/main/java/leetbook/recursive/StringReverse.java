package leetbook.recursive;

/**
 * @author: yh_wang
 * @date: 2023-03-30 09:38
 **/
public class StringReverse {

    public static void main(String[] args) {
        String world = "hello";

        System.out.println(reverse(world));
    }


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
