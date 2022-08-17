class Solution:
    def threeSum(self, nums):
        nums.sort()
        res = []
        
        for i, left in enumerate(nums[:len(nums)-2]):
            if i > 0 and left == nums[i-1]: #avoid duplicates
                continue
                
            mid = i+1
            right = len(nums)-1
            
            while mid < right:
                currSum = nums[mid] + nums[right] + left
                if currSum < 0:
                    mid+=1
                elif currSum > 0:
                    right-=1
                else:
                    res.append([left, nums[mid], nums[right]]);
                    #avoid duplicates
                    while mid < right and nums[mid]==nums[mid+1]:
                        mid += 1
                    while mid < right and nums[right]==nums[right-1]:
                        right -= 1
                        
                    mid += 1
                    right -= 1
            
        return res
                    
        
