package leetbook.list;

/**
 * @author: yh_wang
 * @date: 2023-03-30 11:36
 **/
public class Palindrome {

    public static void main(String[] args) {

    }

    public boolean solution(SingleLinkedList head) {
        if (head == null || head.next == null) {
            return true;
        }

        SingleLinkedList prev = null;
        SingleLinkedList slow = head;
        SingleLinkedList fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            SingleLinkedList next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.value != prev.value) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }

}

