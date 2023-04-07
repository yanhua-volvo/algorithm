package leetbook.queue;

/**
 * @author: yh_wang
 * @date: 2023-04-07 11:26
 **/
public class CycleQueue {

    //循环队列

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

    public CycleQueue(int capacity){
        this.items = new String[capacity];
        this.capacity = capacity;
    }

    /**
     * 入队
     */
    public boolean enqueue(String str){
        //判断队列是否已满
        if((tail+1) % capacity == head){
            return false;
        }
        //循环的效果
        items[tail] = str;
        tail = (tail + 1) % capacity;
        return true;
    }

    /**
     * 出队
     */
    public String dequeue(){
        //对列为空
        if(head == tail){
            return null;
        }
        String s = items[head];
        //head到队列的最大容量后，从新的索引开始
        head = (head +1) % capacity;
        return s;
    }
}
