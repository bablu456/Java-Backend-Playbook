import java.util.List;

class ListNode{
    int val;
    ListNode next;

    ListNode(int x){
        val = x ;
        next = null;
    }
}


public class LinkedListCycle {
    public static void main(String[] args){
        ListNode head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);

        head.next = second;
        second.next = third;
        third.next = head;

        fourth.next = second;

        boolean result = hasCycle(head);

        if(result){
            System.out.println(" Alert: Loop Detected! Server crash hone se bacha liya.");

        }else{
            System.out.println(" Clean Code: No Loop found.");
        }
    }
    public static boolean hasCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
