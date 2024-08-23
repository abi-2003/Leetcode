class Solution {
    public List<List<String>> solveNQueens(int n) {

  
        List<List<String>> result=new ArrayList<>();
        if(n==0) return result;
        backtrace(result,new ArrayList<String>(),0,n,new boolean[n]);
        return result;
    }
    public static void backtrace(List<List<String>> result, List<String> list, int level, int n, boolean[] used){
        if(level == n) result.add(new ArrayList<String>(list));
        else{
            for(int i = 0; i < n; i++){
                if(used[i]) continue;
                if(isValid(list, level, i, n)){
                    list.add(createQueen(n, i));
                    used[i] = true;
                    backtrace(result, list, level + 1, n, used);
                    used[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
   public static boolean isValid(List<String> list, int row, int column, int n) {
    
    for (int i = 0; i < row; i++) {
        if (list.get(i).charAt(column) == 'Q') {
            return false;
        }
    }

    for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
        if (list.get(i).charAt(j) == 'Q') {
            return false;
        }
    }

    for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
        if (list.get(i).charAt(j) == 'Q') {
            return false;
        }
    }

    return true;
}

    public static String createQueen(int n,int index){
        StringBuilder st=new StringBuilder();
        int i=0;
        for(;i<index;i++){
            st.append('.');
        }
        st.append('Q');
        for(++i;i<n;i++){
            st.append('.');
        }
        return st.toString();

    }

}