/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
 #define MAX_RESULT 100 
 #define BUFFER_SIZE 50  
char** summaryRanges(int* nums, int numsSize, int* returnSize) {
    char** result = (char**)malloc(MAX_RESULT * sizeof(char*));
    *returnSize = 0;

    if (numsSize == 0) return result;

    int start = nums[0];
    for (int i = 1; i <= numsSize; i++) {
        
        if (i == numsSize || nums[i] != nums[i - 1] + 1) {
            result[*returnSize] = (char*)malloc(BUFFER_SIZE * sizeof(char)); 
            
            if (start == nums[i - 1]) {
                snprintf(result[*returnSize], BUFFER_SIZE, "%d", start);
            } else {
                snprintf(result[*returnSize], BUFFER_SIZE, "%d->%d", start, nums[i - 1]);
            }
            
            (*returnSize)++;
            if (i < numsSize) start = nums[i]; 
        }
    }

    return result;
}