/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right){
            return head;
        }

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode temp1=head;
        for(int i=0;i<left-1;i++){
            prev=prev.next;
            temp1=temp1.next;
        }

        ListNode temp2=head;
        for(int i=0;i<right-1;i++){
            temp2=temp2.next;
        }
        ListNode next=temp2.next;

        prev.next=null;
        temp2.next=null;
        //reversing ll now

        ListNode revprev=null;
        ListNode revcurr=temp1;
        ListNode revnext;
        while(revcurr!=null){
            revnext=revcurr.next;
            revcurr.next=revprev;
            revprev=revcurr;
            revcurr=revnext;
        }

        prev.next=revprev;
        
        ListNode fnt=dummy;
        ListNode fnprev=null;
        while(fnt!=null){
            fnprev=fnt;
            fnt=fnt.next;
        }
        fnprev.next=next;

        return dummy.next;
        
    }
    }
    