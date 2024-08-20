import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
 
        Set<Integer> distances = new HashSet<>();
        distances.add(distanceSquared(p1, p2));
        distances.add(distanceSquared(p1, p3));
        distances.add(distanceSquared(p1, p4));
        distances.add(distanceSquared(p2, p3));
        distances.add(distanceSquared(p2, p4));
        distances.add(distanceSquared(p3, p4));
        
      
        
            return distances.size()==2 && !distances.contains(0);
        }
       
    

    private int distanceSquared(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
