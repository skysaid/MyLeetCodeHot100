package test1;

import java.util.HashSet;
import java.util.Set;

public class Algorithm142 {
    public ListNode detectCycle2(ListNode head) {
        if (head==null)return null;
        ListNode cur=head;
        Set<ListNode> set= new HashSet<>();
        while (cur!=null){
            if (!set.contains(cur)){
                set.add(cur);
            }else {
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    public ListNode detectCycle(ListNode head) {
        if (head==null)return null;
        ListNode fast=head;
        ListNode slow=head;


        while(fast!=null){

            if (fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                if(fast==slow)break;
            }else return null;
        }
        if (fast==null)return null;
        fast=head;
        while (fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}
