class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        def recurse(nums: List[int], n: int, res: List[List[int]], curr: List[int]):
            #subset formed
            if n == 0 and curr not in res:
                res.append(curr)
                return
            
            #not enough elements to form the subset with length n
            if len(nums) < n:
                return
            
            for i, _ in enumerate(nums):
                temp = curr.copy()
                temp.append(nums[i])
                recurse(nums[i+1:], n-1, res, temp)
            
            
        #empty set and set itself are always a powerset
        res = []
        res.append([])
        #since according to the constraint, nums.length is at least 1, we can append nums to result
        #if nums.length can be 0, we cannot append nums again as it will be duplicated with empty set above
        res.append(nums.copy())
        
        for i in range(1, len(nums)):
            recurse(nums, i, res, [])
        
        
        return res
