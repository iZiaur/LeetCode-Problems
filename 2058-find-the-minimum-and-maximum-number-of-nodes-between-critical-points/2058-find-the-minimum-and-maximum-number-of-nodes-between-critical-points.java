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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> arr=new ArrayList<>();
        ListNode temp=head;

        while(temp!=null){
            arr.add(temp.val);
            temp=temp.next;
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<arr.size()-1;i++){
            if(arr.get(i)>arr.get(i-1) && arr.get(i)>arr.get(i+1) 
            || arr.get(i)<arr.get(i-1) && arr.get(i)<arr.get(i+1)){
                list.add(i);
            }
    
        }
        int ans[]={-1,-1};
        if(list.size()<2){
            return ans;
        }
        
        int min=Integer.MAX_VALUE;
        int max=list.get(list.size()-1)-list.get(0);
        for(int i=1;i<list.size();i++){
            min=Math.min(min,list.get(i)-list.get(i-1));
        }
        ans[0]=min;
        ans[1]=max;
        return ans;
    }

}