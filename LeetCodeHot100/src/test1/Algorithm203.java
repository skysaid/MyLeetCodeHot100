package test1;

public class Algorithm203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head==null)return null;
        ListNode dummy=new ListNode(val+1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=head;
        while (pre.next!=null){
            if (cur.val==val){
                pre.next=cur.next;
                cur=cur.next;
            }else {
                pre=pre.next;
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
