class Solution {
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        int end=nums[0];

        for(int i=1;i<nums.length;i++){
            end=Math.max(nums[i]+end,nums[i]);
            res=Math.max(res,end);

        }
        return res;
    }
}