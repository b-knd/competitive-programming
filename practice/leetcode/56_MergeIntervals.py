class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        
        res = []
        intervals.sort(key=lambda y: y[0])
        print(intervals)
        i = 0
        while i < len(intervals):
            lb = intervals[i][0]
            ub = intervals[i][1]
            while i < len(intervals)-1 and ub >= intervals[i+1][0]:
                ub = max(ub, intervals[i+1][1])
                lb = min(lb, intervals[i+1][0])
                i += 1
            # i now points to the last interval to be merged with starting interval
            res.append([lb, ub])
            i += 1
        return res
