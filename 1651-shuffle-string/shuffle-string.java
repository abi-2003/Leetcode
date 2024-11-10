class Solution {
    public String restoreString(String s, int[] indices) {
        String st="";
        for(int i=0;i<indices.length;i++){
            for(int j=0;j<indices.length;j++){
                if(indices[j]==i){
                    st+=s.charAt(j);
                }
            }
        }
        return st;
    }
}