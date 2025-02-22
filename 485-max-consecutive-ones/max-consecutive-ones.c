int findMaxConsecutiveOnes(int* nums, int numsSize) {
   int mx = 0, cnt = 0;

    for (int i = 0; i < numsSize; i++) {
        if (nums[i] == 1) {
            cnt++;
        } else {
            if (cnt > mx) mx = cnt; 
            cnt = 0;
        }
    }

    if (cnt > mx) mx = cnt;  
    return mx;
}