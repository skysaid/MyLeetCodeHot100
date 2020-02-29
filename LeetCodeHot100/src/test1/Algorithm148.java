package test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Algorithm148 {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list=new ArrayList<>();
        for(ListNode cur=head;cur!=null;cur=cur.next){
            list.add(cur.val);
        }
        Collections.sort(list);

        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        for (int i=0;i<list.size();i++){
            cur.next=new ListNode(list.get(i));
            cur=cur.next;
        }
        return dummy.next;

    }

    public ListNode sortList2(ListNode head) {
        if(head==null)return head;
        if(head.next==null)return head;
        ListNode fast=head;
        ListNode slow=head;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode nextHead=slow.next;
        //从中间节点分成两个链表
        slow.next=null;

        ListNode left=sortList2(head);
        ListNode right=sortList2(nextHead);

        ListNode res=new ListNode(-1);
        ListNode cur=res;
        while (left!=null&&right!=null){
            if (left.val<=right.val){
                cur.next=left;
                left=left.next;
            }else {
                cur.next=right;
                right=right.next;
            }
            cur=cur.next;
        }
        cur.next=(left==null)?right:left;
        return res.next;
    }

    public ListNode sortList3(ListNode head) {
        if (head==null)return head;
        int len=findsize(head);

        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        for(int i=1;i<len;i=i<<1){
        ListNode pre=dummy;
        ListNode cur=dummy.next;
            while(cur!=null){
                ListNode left=cur;
                ListNode right=split(cur,i);
                cur=split(right,i);
                pre.next=merge(left,right);
                while (pre.next!=null){
                    pre=pre.next;
                }
            }
        }
        return dummy.next;
    }

    private int findsize(ListNode head){
        int size=0;
        while(head!=null){
            head=head.next;
            size++;
        }
        return size;
    }

    //按步数分割链表,返回下一段的开头
    private ListNode split(ListNode head,int step){
        if (head==null)return head;
        for (int i=1;i<step&&head.next!=null;i++){
            head=head.next;
        }
        ListNode right=head.next;
        head.next=null;
        return right;
    }

    //合并两个链表
    private ListNode merge(ListNode left,ListNode right){
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while(left!=null&&right!=null){
            if (left.val<=right.val){
                cur.next=left;
                left=left.next;
            }else {
                cur.next=right;
                right=right.next;
            }
            cur=cur.next;
        }
        cur.next=left!=null?left:right;
        return dummy.next;
    }
}
