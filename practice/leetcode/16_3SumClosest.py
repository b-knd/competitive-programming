class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        nums.sort()
        
        res = nums[0] + nums[1] + nums[2]
        
        for left in range(len(nums)-2):
            if left > 0  and nums[left]==nums[left-1]:
                continue
            
            mid = left+1
            right = len(nums)-1
            
            while mid < right:
                currSum = nums[left] + nums[mid] + nums[right]
                if currSum == target:
                    return currSum
                
                if abs(target-currSum) < abs(target-res):
                    res = currSum
                    
                if currSum < target:
                    while mid < right and nums[mid] == nums[mid + 1]:
                        mid+=1
                    mid+=1
                elif currSum > target:
                    while mid < right and nums[right] == nums[right-1]:
                        right-=1
                    right-=1
        return res
            
        
        
        
