//O(N) time complexity
//O(1) space complexity

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int toGain = 0;
        int toLose = tokens.length-1;
        int score = 0;
        
        Arrays.sort(tokens);
        
        //cannot start game
        if(tokens.length == 0 || tokens[toGain] > power){
            return score;
        }
                
        while(toGain <= toLose){
            //when do we need to gain: score == 0
            //need to gain
            if(score == 0){
                //end game
                if(tokens[toGain] > power){
                    break;
                }
                score++;
                power -= tokens[toGain];
                toGain++;
            }
            //score is greater than 0
            //we keep gaining score if toGain is possible
            //otherwise, lose score to gain power
            else {
                if(tokens[toGain] <= power){
                    score++;
                    power -= tokens[toGain];
                    toGain++;
                } else{
                    if(toGain != toLose){
                        score--;
                        power += tokens[toLose];
                    }
                    toLose--;
                }
            }
        }
        return score;
    }
}
