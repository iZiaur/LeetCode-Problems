class Solution {

    public int gcd(int a,int b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }
    public int gcdOfOddEvenSums(int n) {
        int evensum=0;
        int oddsum=0;

        for(int i=1;i<=2*n;i++){
            if(i%2==1){
                oddsum+=i;
            }else{
                evensum+=i;
            }
        }
        return gcd(evensum,oddsum);
        
    }
}