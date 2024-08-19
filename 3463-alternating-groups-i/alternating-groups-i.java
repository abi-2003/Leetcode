class Solution {
    public int numberOfAlternatingGroups(int[] colors) {

        int n=colors.length;
             int res=0;
        for(int i=0;i<n;i++){
            int pre=colors[(i-1+n)%n];
            int cur=colors[i];
            int next=colors[(i+1)%n];

                  if(pre != cur && cur!= next){
                    res++;
                  }
        }
        return res;
        
    }
}