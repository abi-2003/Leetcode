

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* numberOfLines(int* widths, int widthsSize, char * s, int* returnSize){

int* result = (int*)malloc(2 * sizeof(int));
    *returnSize = 2;

    int lines = 1, width = 0;

    for (int i = 0; s[i] != '\0'; i++) {
        int w = widths[s[i] - 'a'];  

        if (width + w > 100) {  
            lines++;
            width = w;  
        } else {
            width += w;  
        }
    }

    result[0] = lines;
    result[1] = width;
    return result;
}