package leetbook.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author: yh_wang
 * @date: 2023-04-07 11:09
 **/
public class ListQueue {

    public static void main(String[] args) {

        //arrayDeque, LinkedList均实现了此接口
        Deque<String> queue = new ArrayDeque<>();
        queue.addLast("abc");

        String first = queue.getFirst();

        Queue<String> queue1 = new ArrayDeque<>();


    }
}
