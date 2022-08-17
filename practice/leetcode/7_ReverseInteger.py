class Solution:
    def reverse(self, x: int) -> int:
        rev = 0
        neg = True if x < 0 else False
        x = -x if neg else x
        
        while x != 0:
            pop = int(x % 10)
            x = int(x/10)
            if not neg and rev > (2**31-1)/10 or (rev == (2**31-1)/10 and pop > 7):
                return 0
            if neg and rev > (2**31)/10 or (rev == (2**31)/10 and pop > 8):
                return 0
            rev = rev * 10 + pop
            
        return -rev if neg else rev
