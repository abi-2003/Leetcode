

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* numberOfLines(int* widths, int widthsSize, char * s, int* returnSize){
      
        int *res=(int*)malloc(2*sizeof(int));
      *returnSize=2;
        int line=1, width=0;

        for(int i=0;i<strlen(s);i++){
            int w=widths[s[i]-'a'];
            if(width+w>100){
                line++;
                width=w;
            }
            else{
                width+=w;
            }
            
        }
        res[0]=line;
        res[1]=width;
        return res;
}