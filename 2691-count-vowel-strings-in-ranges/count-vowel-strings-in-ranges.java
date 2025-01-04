class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length;
        int arr[]=new int [n];
          int num=0;
        for(String s:words){
            int len=s.length();
            int flag=0;
           
                if((s.charAt(0)=='a'||s.charAt(0)=='e'||s.charAt(0)=='i'||s.charAt(0)=='o'||s.charAt(0)=='u') &&( s.charAt(len-1)=='a'||s.charAt(len-1)=='e'||s.charAt(len-1)=='i'||s.charAt(len-1)=='o'||s.charAt(len-1)=='u')){
                    flag=1;
                
                }
            
                if(flag==0){
                    arr[num]=0;
                }
                else{
                    arr[num]=1;
                }
                num++;
            
            
        }

        int q=queries.length;
        int sum=0;
         int z=0;
         int res[]=new int[q];
        for(int k=0;k<q;k++){
            sum=0;
           int m=queries[k][0];
            int b=queries[k][1];

            for(int a=m;a<=b;a++){
                sum+=arr[a];
            }
            res[z++]=sum;
        }
        return res;

    }
}


