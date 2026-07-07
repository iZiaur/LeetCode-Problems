class Solution {
    public long sumAndMultiply(int n) {
        if(n==0){
            return 0;
        }
     StringBuilder str=new StringBuilder();
       long sum=0; 
       long temp=n;
       while(temp>0){
        long digit=temp%10;
        if(digit!=0){
            str.append(digit);
        }
        sum+=digit;
       temp=temp/10;
       }
       str.reverse();
        long orignalnum=Long.parseLong(str.toString());
        long ans=orignalnum*sum;
        return ans; 
        
    }
    
}