class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> li= new ArrayList<>();
        
        for(int x:nums1){
            li.add(x);
        }

        
        for(int x:nums2){
            li.add(x);
        }

        Collections.sort(li);

        int size=li.size();

        if(size % 2==0){
            return( (double)(li.get(size/2-1)+li.get(size/2))/2);
        }
        else
        return li.get(size/2);
        
        
            }
}