package gshar.dsalgo.linkedlist;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class SumLeftToRight {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode l3=l1;
        ListNode l4=l2;
        int temp=0;
        int carry=0;
        do{
            temp=l1.val+l2.val+carry;
            carry=temp/10;
            temp=temp%10;

            l1.val=temp;
            l2.val=temp;
            l1=l1.next;
            l2=l2.next;
        } while(l1!=null && l2!=null);
    
    ListNode result=null;
    ListNode current=null;
    if(l1==null){
         result=l4;
         current=l2;
    }else {
         result=l3;
         current=l1;
    }
    
    while(current!=null){
        temp=carry+current.val;
        carry=temp/10;
        temp = temp%10;
        current.val += temp;
    }
    
    if(carry==1){
        ListNode last=new ListNode(carry);
        current.next=last;
    }
    
    return result;
    }
}
