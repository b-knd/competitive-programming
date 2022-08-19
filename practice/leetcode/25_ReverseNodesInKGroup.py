#my iterative solution
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        #find size and group to be reversed
        size = 0
        temp = head
        while temp != None:
            size += 1
            temp = temp.next
        groups = size // k
        
        count = 0
        dummyHead = None
        prev = None
        prevTail = ListNode(0)
        
        while groups > 0:
            currTail = head
            #reverse group
            while count < k:
                next = head.next
                head.next = prev
                prev = head
                head = next
                count += 1
                
            if not dummyHead:
                dummyHead = prev
            
            #connect with previously reversed group, reset count and update groups
            prevTail.next = prev
            prevTail = currTail
            groups -= 1
            count = 0
        
        #link reversed list and remaining list
        currTail.next = head
        return dummyHead
