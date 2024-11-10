class Solution {
    public int minimumSum(int num) {
       int arr[]=new int[4];
int i=0;
       while(num>0){
        int d=num%10;
        arr[i++]=d;
        num/=10;
       }
       Arrays.sort(arr);
       
       int sum=(arr[0]*10+arr[3])+(arr[1]*10+arr[2]);
       return sum;
    }
}