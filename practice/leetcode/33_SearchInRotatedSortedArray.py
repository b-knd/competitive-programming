class Solution:
    def search(self, nums: List[int], target: int) -> int:
      
        start = 0
        end = len(nums)-1
        
        #out of range
        if target < nums[start] and target > nums[end]:
            return -1
        
        while start <= end:
            mid = (start + end) // 2
            #return index if found target
            if target == nums[mid]:
                return mid
              
            #if target is smaller than mid
            if target < nums[mid]:
                #this means we are in rotation (start < mid > end)
                #if target <= nums[end] means target in right half, so change start (start < mid > target <= end, end < start)
                #if target > nums[end] means target is in left half, we change end (start < target < mid > end, end < start)
                if nums[mid] > nums[end]:
                    if target <= nums[end]:
                        start = mid+1
                    else:
                        end = mid-1
                #not in rotation, element in ascending, normal binary search
                else:
                    end = mid-1
            else:
                #in rotation (start < mid > end) 
                #if target >= nums[start], target in left half (start <= target > mid > end, end < start)
                #if target < nums[start], target in right half (start < mid > target > end, end < start)
                if nums[mid] < nums[start]:
                    if target >= nums[start]:
                        end = end-1
                    else:
                        start = start+1
                #not in rotation, normal binary search
                else:
                    start = mid+1
        #start and end overlap, cannot find target
        return -1
