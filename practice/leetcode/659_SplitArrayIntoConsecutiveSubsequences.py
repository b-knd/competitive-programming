class Solution:
    def isPossible(self, nums: List[int]) -> bool:
        #pre: element processed immediately before curr
        #p1, p2, p3: number of consecutive subarray with length 1, 2 and >=3 ending at pre
        pre, p1, p2, p3 = None, 0, 0, 0
                
        
        i, n = 0, len(nums)
        while i < n:
            #curr: element currently being examined
            curr = nums[i]
            
            #numer of appearances for current value
            count = 0
            while i < n and nums[i] == curr:
                count += 1
                i += 1
            
            #case 1: current value is not consecutive of previous value
            if pre is None or curr != pre + 1:
                #there shall be no length 1 or 2 sequences ending at pre (if yes and we cannot extend their length means there are subarray with length < 3)
                if p1 or p2:
                    return False

            #c1, c2, c3: number of consecutive subarray with length 1, 2 and >=3 ending at cur    
                c1, c2, c3 = count, 0, 0

            else:
                #there shall be enough values to fill previous length 1 and length 2 sequences
                if p1 + p2 > count:
                    return False

                c2 = p1 #length one subarray ending with pre now extend to length two ending at cur

                #if there are remaining cur after filling in length 1 and 2
                #if p3 < cnt - (p1 + p2) means we have enough cur to extend all p3 to longer subarrays
                #otherwise, we only can extend extra (cnt-p1-p2) p3 subarrays to longer ones ending at cur
                c3 = p2 + min(p3, count - (p1+p2))
                #if there are some values left after filling length 1, 2, 3 then the remainder become start of new length 1 sequences
                c1 = max(0, count-p1-p2-p3)

            pre,p1,p2,p3 = curr,c1,c2,c3

        #at the very end, there should be no length 1 or 2 sequence unfilled
        return not p1 and not p2

