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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode temp = head;
        int size = 0;
        //traverse once to find size of list
        while(temp != null){
            size++;
            temp = temp.next;
        }
      
        //find which index to remove, setting prev node to initially null, updated every time in loop
        int index = size-n;
        temp = head;
        ListNode prev = null;
        for(int i = 0; i < index; i++){
            prev = temp;
            temp = temp.next;
        }
      
        //prev == null means the node to remove is head, simply update head and return
        //temp == null means the node to be removed is tail, simply set prev.next to null
        //otherwise, remove node as normal
        if(prev == null){
            head = temp.next;
        } else if(temp != null){
            prev.next = temp.next;
        } else{
            prev.next = null;
        }
        return head;
    }
}
