package leetbook.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: yh_wang
 * @date: 2023-04-06 17:12
 **/
public class ListStack {

    LinkedList<String> linkedStack = new LinkedList<>();

    public boolean push(String str){
        linkedStack.push(str);
        return true;
    }

    public String pop(){
        return linkedStack.pop();
    }

    Deque<Integer> stack = new ArrayDeque<>();

}
