class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        occurrences = {}
        
        for i, value in enumerate(arr):
            if value in occurrences:
                occurrences[value] += 1
            else:
                occurrences[value] = 1
        
        array = []
        for i, (k, v) in enumerate(occurrences.items()):
            array.append(v)
        array.sort()
        
        count = 0
        sum = 0
        index = len(array)-1
        while sum < len(arr)//2:
            sum += array[index]
            index -= 1
            count += 1
        return count
