class Solution {
    public boolean canAliceWin(int[] nums) {
        int sum=0;
        int dsum=0;
        for(int x:nums){
            if(x < 10){
                sum+=x;
            }
            else{
             dsum+=x;
            }
        }

        if(sum != dsum){
            return true;
        }
        return false;
    }
}