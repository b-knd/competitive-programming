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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
      
        //find out size and number of groups to be reversed
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        int groups = size / k;
        
        ListNode dummyHead = null;
        ListNode prev = null, next = null;
        //currTail is the tail of current group, prevTail is the tail of previous group
        ListNode currTail = null, prevTail = new ListNode();
        
        int count = 0;
        while(groups > 0){
            //currTail is always first of group (first -> tail after reversing)
            currTail = head;
            //reverse list (refer reverse linked list question in leetcode)
            while(count < k){
                if(head != null) next = head.next;
                head.next = prev;
                prev = head;
                head = next;
                count++;
            }
            //update groups and reset count
            groups--;
            count = 0;
            //instantiate dummyHead if not already done so to the last element of first k group
            if(dummyHead == null) dummyHead = prev;
            //linked previous group with current group and update prevTail
            prevTail.next = prev;
            prevTail = currTail;
            //prev is reset to null as we will reverse new group in next while loop
            prev = null;
        }
        //head is now the remaining of list, either null (all elements are reversed) or head of remaining list (reverse all group but there are remaining nodes)
        //link currTail (tail of the reversed list) to head and return dummyHead
        currTail.next = head;
        return dummyHead;
    }
}
