import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);  // First element of each row is 1
            
            // Compute the values for the current row
            for (int j = 1; j < i; j++) {
                List<Integer> prevRow = result.get(i - 1);
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            if (i > 0) {
                row.add(1);  // Last element of each row is 1
            }
            
            result.add(row);
        }
        
        return result;
    }
}
