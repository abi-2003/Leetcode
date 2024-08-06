class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        // Edge case for empty array
        if (nums.length == 0) {
            return result;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (nums[mid] == target) {
                // Find the left boundary
                int left = mid;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                result[0] = left + 1;

                // Find the right boundary
                int right = mid;
                while (right < nums.length && nums[right] == target) {
                    right++;
                }
                result[1] = right - 1;
                
                return result;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return result;
    }
}
