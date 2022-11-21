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
    //concept: merge sort
  
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode[] split = halve(head);
        return mergeList (sortList(split[0]),sortList(split[1]));
    }
    
    //function to split nodes into two halves
    public ListNode[] halve(ListNode node){
        int n = countNode(node);
        n = n % 2 == 0? n/2 : (n/2)+1;
        ListNode[] res = new ListNode[2];
        res[0] = node;
        int counter = 0;
        while(counter < n-1){
            node = node.next;
            counter++;
        }
        res[1] = node.next;
        node.next = null;
        return res;
    }
    
    //function to count number of nodes (used in splitting)
    public int countNode(ListNode node){
        int i = 0;
        while(node != null){
            i++;
            node = node.next;
        }
        return i;
    }
    
    //function to merge two list
    public ListNode mergeList(ListNode head1, ListNode head2){
        if(head2 == null){
            return head1;
        }
        if(head1 == null){
            return head2;
        }

        ListNode temp;
        ListNode next1;
        ListNode next2;
        if(head1.val <= head2.val){
            temp = head1;
            next1 = head1.next;
            next2 = head2;
        } else{
            temp = head2;
            next1 = head2.next;
            next2 = head1;
        }
        temp.next = mergeList(next1, next2);
        return temp;
    }
}
