package leetbook.queue;

/**
 * @author: yh_wang
 * @date: 2023-04-07 10:45
 **/
public class ArrayQueue {
    //数组实现队列

    private String[] items;

    /**
     * 容量
     */
    private int capacity;

    /**
     * 队列头
     */
    private int head =0;

    /**
     * 队列尾
     */
    private int tail =0;

    /**
     * 元素个数
     */
    private int count;

    public ArrayQueue(int capacity){
        this.items = new String[capacity];
        this.capacity = capacity;
    }

    /**
     * 入队
     */
    public boolean enqueue(String str){
        if(tail == capacity){
            //队列满了,触发数据迁移
            if(head == 0){
                return false;
            }
            for(int i=head;i<tail;i++){
                items[i-head] = items[head];
            }
            tail -= head;
            head =0;
        }
        //队尾入队
        items[tail] = str;
        ++tail;
        return true;
    }

    /**
     * 出队
     */
    public String dequeue(String str){
        //对列为空
        if(head == tail){
            return null;
        }
        String s = items[head];
        ++ head;
        return s;
    }


}
