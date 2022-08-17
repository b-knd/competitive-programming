class Solution:
    
    def __init__(self):
        self.letters = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
        
    def letterCombinations(self, digits: str) -> List[str]:
        result = []
        self.recurse(result, digits, "")
        return result
    
    def recurse(self, result: List[str], digits: str, curr: str):
        if len(digits) == 0:
            if len(curr) > 0:
                result.append(curr)
            return
        for i, char in enumerate(self.letters[int(digits[0])]):
            self.recurse(result, digits[1:], curr+char);
