package test1;

public class Algorithm160 {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA==null||headB==null)return null;
        for (ListNode i=headA;i!=null;i=i.next){

            for (ListNode j=headB;j!=null;j=j.next){
                if (i==j){
                    return i;
                }
            }

        }
        return null;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA==null||headB==null)return null;
        ListNode c1=headA;
        ListNode c2=headB;
        while(c1!=null||c2!=null){
            if (c1==c2)return c1;
            if (c1==null){
                c1=headB;
                c2=c2.next;
                continue;
            }else
            if (c2==null){
                c2=headA;
                c1= c1.next;
                continue;
            }else {
                c1=c1.next;
                c2=c2.next;
            }


        }

        return null;
    }


}


