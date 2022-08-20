class Solution:
    def longestValidParentheses(self, s: str) -> int:
        res = 0
        stack = []
        
        stack.append(-1)
        for i, char in enumerate(s):
            if char == '(':
                stack.append(i);
            else:
                #if encounter ) and stack becomes empty means invalid so we start a new substring search
                stack.pop()
                if not stack:
                    stack.append(i)
                else:
                    res = max(res, i-stack[-1])
                    
        return res
