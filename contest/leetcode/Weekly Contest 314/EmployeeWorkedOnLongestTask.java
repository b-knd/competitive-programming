class Solution {
    public int hardestWorker(int n, int[][] logs) {
        //make first as the longest task
        int id = logs[0][0];
        int longestUnit = logs[0][1];
        
        //loop through and compare, update if longer than current max (if same, compare id and use the smaller one)
        for(int i = 1; i < logs.length; i++){
            
            if(logs[i][1] - logs[i-1][1] == longestUnit){
                if(logs[i][0] < id){
                    id = logs[i][0];
                }
            } else if(logs[i][1] - logs[i-1][1] > longestUnit){
                id = logs[i][0];
                longestUnit = logs[i][1]-logs[i-1][1];
            }
            
        }
        return id;
    }
}
