class Solution {
    public int numOfSubarrays(int[] arr) {
        int even=1;
        int odd=0;
        int modulo=(int)1e9+7;
        int total=0;
        int prefix=0;

        for(int i=0;i<arr.length;i++){
            prefix+=arr[i];
            if(prefix%2==1){
                total=(total+even)%modulo;
                odd++;
            }else{
                 total=(total+odd)%modulo;
                 even++;
            }
        }
        return total;
    }
}