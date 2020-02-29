package test1;

public class ListNode {
	 int val;
     ListNode next;
     ListNode(int x) { val = x; }
     ListNode(int[] nums){
         if(nums==null||nums.length==0){
              throw new IllegalArgumentException("nums should not null");
         }
         this.val=nums[0];
         ListNode cur=this;
         for(int i=1;i<nums.length;i++){
             cur.next=new ListNode(nums[i]);
             cur=cur.next;
         }
     }

    @Override
    public String toString() {
        if(this==null)return "";
        ListNode cur=this;
        StringBuffer sb= new StringBuffer();
        sb.append("Node head : [ ");
        while (cur!=null){
            sb.append(cur.val);
            sb.append(" --> ");
            cur=cur.next;
        }
        sb.append("null ]");
        return sb.toString();
    }

    public static void main(String[] args) {
         int[] nums ={1,2,6,3,4,5,6};
        ListNode head=new ListNode(nums);
        System.out.println(head.toString());
    }
}
