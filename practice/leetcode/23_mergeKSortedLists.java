//improved version using priority queue (O(N log k) time complexity O(N) space to create new list, O(k) space for priority queues
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode curr = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode l: lists){
            if(l != null){
                pq.add(l);
            }
        }
        while(!pq.isEmpty()){
            ListNode n = pq.poll();
            curr.next = new ListNode(n.val);
            curr = curr.next;
            n = n.next;
            if(n != null){
                pq.add(n);
            }
        }
        return head.next;
    }
}


//my solution (O(kN) time complexity, O(N) space complexity
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        if(lists.length < 2){
            return (lists.length == 0 ? null: lists[0]); 
        }
        for(int i = 0; i < lists.length-1; i++){
            lists[i+1] = mergeTwoList(lists[i], lists[i+1]);
        }
        return lists[lists.length-1];
    }
    
    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        dummyHead = curr;
        
        while(l1 != null || l2 != null){
            if(l1 == null){
                curr.next = l2;
                break;
            }
            if(l2 == null){
                curr.next = l1;
                break;
            }
            if(l1.val <= l2.val){
                curr.next = l1;
                while(l1 != null && l1.val <= l2.val){
                    l1 = l1.next;
                    curr = curr.next;
                }
            } else{
                curr.next = l2;
                while(l2 != null && l2.val < l1.val){
                    l2 = l2.next;
                    curr = curr.next;
                }
            }
        }
        return dummyHead.next;
    }
}
