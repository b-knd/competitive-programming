class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if not nums:
            return [-1, -1]
        
        start = 0
        end = len(nums)-1
        
        #we stop when both start and end pointer points to target
        #we also stop when start and end overlap, means we could not find target
        while start < end and (nums[start] != target or nums[end] != target):
            mid = (start + end) // 2
            #expand from mid
            if nums[mid] == target:
                temp1 = temp2 = mid
                while temp1 > start and nums[temp1-1] == target:
                    temp1 -= 1
                while temp2 < end and nums[temp2+1] == target:
                    temp2 += 1
                start = temp1
                end = temp2
            elif nums[mid] < target:
                start = mid + 1
            else:
                end = mid - 1
        
        if nums[start] == target and nums[end] == target:
            return [start, end]
        else:
            return [-1, -1]
            
        
