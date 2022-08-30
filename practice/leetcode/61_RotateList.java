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
    public ListNode rotateRight(ListNode head, int k) {
        //return if list is empty
        if(head == null) return head;
        
        ListNode temp = head;
        ListNode tail = null;
        int size = 1;
        
        //find size and tail node
        while(temp.next != null){
            size++;
            temp = temp.next;
        }
        tail = temp;
        
        //no rotation needed
        if(k % size == 0){
            return head;
        }
        
        k = size - (k % size);
        
        temp = head;
        while(k > 1){
            k--;
            temp = temp.next;
        }
        
        //change links between nodes
        ListNode dummyHead = temp.next;
        temp.next = null;
        tail.next = head;
        return dummyHead;
    }
}
