class Solution {





     boolean check(String s) {
        return "aeiou".indexOf(s.charAt(0)) != -1 && "aeiou".indexOf(s.charAt(s.length() - 1)) != -1;
      }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] n = new int[words.length];
        int[] ans = new int[queries.length];

        for (int i = 0; i < words.length; i++) {
            n[i] = check(words[i]) ? 1 : 0;
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
                sum+=n[a];
            }
            res[z++]=sum;
        }
        return res;

    }
}


