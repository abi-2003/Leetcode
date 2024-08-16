class Solution {
    public int[] decode(int[] encoded) {
        
        int n=encoded.length+1;
             int a=0,b=0;
        for( int i=1;i<encoded.length;i+=2){
             a^=encoded[i];
        }
        for(int i=1;i<=n;i++){
             b^=i;
        }

        int first=a^b;

        int []per=new int[n];
        per[0]=first;
        
        for( int i=0;i<encoded.length;i++){
            per[i+1]=encoded[i]^per[i];
        }
        return per;
    }
}