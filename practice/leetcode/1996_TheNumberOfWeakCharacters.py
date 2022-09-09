
class Solution:
    def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:
        #the second priority are x[1], this is such that if first element are the same, we prioritise the one with smaller second element
        #if we don't, [5, 5] and [5, 3] will remain the order and when we loop through the array, we increment count at [5, 3] as 3 is < curr_max (5) even though the first elements are equal
        properties.sort(key=lambda x: (-x[0], x[1]))
        
        count = 0
        curr_max = 0
        
        print(properties)
        for _, arr in properties:
            print(arr)
            if arr < curr_max:
                count += 1
            else:
                curr_max = arr
        return count
