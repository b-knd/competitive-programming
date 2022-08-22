class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int res = 0;
        for(int i = 0; i < energy.length; i++){
            //energy
            //energy strictly greater than enemy's, or else find how many more needed
            //energy is updated by deducting enemy's energy
            if(initialEnergy > energy[i]){
                initialEnergy -= energy[i];
            } else{
                res += (energy[i] - initialEnergy + 1);
                initialEnergy = 1;
            }

            //experience
            //experience strictly greater than enemy's, or else find how many more needed
            //experience is update by adding enemy's experience and adding extra experiences needed
            if(initialExperience > experience[i]){
                initialExperience += experience[i];
            } else{
                res += (experience[i] - initialExperience + 1);
                initialExperience += (experience[i] - initialExperience + 1) + experience[i];
            }
        }
        return res;
    }
}
