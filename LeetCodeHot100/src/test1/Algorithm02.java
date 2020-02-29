package test1;

public class Algorithm02 {
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode temp1=l1;
       ListNode temp2=l2;
       int p=0,q=0,count=0;
       ListNode dummy=new ListNode(0);
       ListNode cur=dummy;
       while(null != temp1||null!=temp2||count!=0) {
    	   p=(temp1==null)?0:temp1.val;
    	   q=(temp2==null)?0:temp2.val;
    	   int add=p+q+count;
    	   count=add>=10?1:0;   	   
    	   cur.next=new ListNode(add%10);
    	   cur=cur.next;
    	   if(temp1!=null)temp1=temp1.next;
    	   if(temp2!=null)temp2=temp2.next;
       }
       return dummy.next;
}
       }
