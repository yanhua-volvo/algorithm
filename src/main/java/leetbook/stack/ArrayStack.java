package leetbook.stack;


/**
 * @author: yh_wang
 * @date: 2023-04-06 16:33
 **/
public class ArrayStack {

    //数组实现固定大小顺序栈
    //先进后出，后进先出 特性，与队列刚好相反

    private String[] items;

    /**
     * 栈容量
     */
    private int capacity = 100;

    /**
     * 栈容器中元素个数
     */
    private int count;

    public ArrayStack(int n){
        items = new String[n];
        this.capacity = n;
        this.count = 0;
    }

    /**
     * 入栈
     * @param str
     */
    public boolean push(String str){
        if(capacity == count){
            return false;
        }
        items[count] = str;
        //栈中元素个数+1
        ++count;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public String pop(){
        if(count ==0){
            return null;
        }
        String item = items[count-1];
        --count;
        return item;
    }




}
