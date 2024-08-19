class Solution {
    public int[] decrypt(int[] code, int k) {
   int n=code.length;     
int sum=0;
int arr[]=new int[n];

        for( int i=0;i<n;i++){
               
                 if(k>0){
                    for( int j=1;j<=k;j++){
                      sum+=code[(i+j)%n];
            
                    }
                }
                else{
                    for( int j=k;j<0;j++){
                      sum+=code[(i+j+n)%n];
                }
                  
                   

                }
                  arr[i]=sum;
                    sum=0;
        }
        return arr;
    }
}