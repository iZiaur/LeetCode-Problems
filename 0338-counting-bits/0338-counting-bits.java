class Solution {

    public static int count(int n){
        int count=0;
        int temp=n;
        while(temp>0){
            if((temp & 1)!= 0){
                count++;
            }
            temp=temp>>1;
        }
        return count;
    }
    public int[] countBits(int n) {
        int arr[]=new int[n+1];
        for(int i=0;i<=n;i++){
            arr[i]=count(i);
        }
        return arr;
    }
}