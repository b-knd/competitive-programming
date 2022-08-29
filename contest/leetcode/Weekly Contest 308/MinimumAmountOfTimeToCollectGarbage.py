class Solution:
    def garbageCollection(self, garbage: List[str], travel: List[int]) -> int:
        res = 0
        lastM = 0
        lastG = 0
        lastP = 0
        
        # each garbage need 1 unit of time for picking up, so we add up length of each string (number of garbage
        # at the same time, we keep on upadating the last index where we found a particular garbage
        for i, string in enumerate(garbage):
            res += len(string)
            if "M" in string:
                lastM = i
            if "G" in string:
                lastG = i
            if "P" in string:
                lastP = i
        
        # add up time from first index to the last index where we find the garbage
        if lastM != 0:
            res += sum(travel[0:lastM])
        if lastP != 0:
            res += sum(travel[0:lastP])
        if lastG != 0: 
            res += sum(travel[0:lastG])
        
        return res
