class Solution {
    public int waysToSplitArray(int[] nums) {
        
        int n=nums.length;
       
        int c=0;
        long sum=0;
    long lsum=0;
    long rsum=0;
     for( int x:nums){
        sum+=x;
     }
     for(int i=0;i<n-1;i++){

        lsum+=nums[i];
        rsum=sum-lsum;
         if(lsum>=rsum){
            c++;
          }
     }
          
        
        return c;
    }
}