//O(n) solution, we make use of the fact the the initial array came sorted
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        
        int i = 0;
        
        //add smaller and non-overlapping intervals
        //upper bound smaller than new interval's lower bound, we can safely add them to result
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        
        //upper bound larger than or equals to new intervals's lower bound, there is overlapping, we need to merge intervals
        //when to stop? new interval's upper bound smaller than interval's lower bound
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        res.add(newInterval);
        
        //add the rest of the intervals
        while(i < intervals.length){
            res.add(intervals[i]);
            i++;
        }
        
        return res.toArray(new int[res.size()][2]);
        
    }
}



//O(nlogn) time complexity due to sorting in merge method
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newMat = new int[intervals.length+1][2];
        System.arraycopy(intervals, 0, newMat, 0, intervals.length);
        newMat[intervals.length] = newInterval;
        return mergeInterval(newMat);
    }
    
    public int[][] mergeInterval(int[][] intervals){   
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);

        //position to modificate
        int pointer = 0;
        
        int lb;
        int ub;
        int i = 0;
        while(i < intervals.length){
            lb = intervals[i][0];
            ub = intervals[i][1];
            while(i < intervals.length-1 && ub >= intervals[i+1][0]){
                i++;
                lb = Math.min(intervals[i][0], lb);
                ub = Math.max(intervals[i][1], ub);
            }
            intervals[pointer] = new int[] {lb, ub};
            pointer++;
            i++;
        }
        return Arrays.copyOfRange(intervals, 0, pointer);
    }
}
