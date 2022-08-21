class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def findIndex(nums:List[int], target: int, first: bool) -> int:
            idx = -1
            start = 0
            end = len(nums)-1
            
            while start <= end:
                mid = (start + end)//2
                if nums[mid] == target:
                    idx = mid
                    
                if (not first and nums[mid] <= target) or (first and nums[mid] < target):
                    start = mid + 1
                else:
                    end = mid - 1
            
            return idx
        
        first = findIndex(nums, target, True)
        last = findIndex(nums,target, False)
        return [first,last]
        
        
