class Solution {
    public int sumSubarrayMins(int[] arr) {
        int nsr[]=new int[arr.length];
        Stack <Integer>st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nsr[i]=arr.length;
            }else{
                nsr[i]=st.peek();
            }
            st.push(i);
        }

        int psl[]=new int[arr.length];
        Stack<Integer> st2=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st2.isEmpty() && arr[st2.peek()]>arr[i]){
                st2.pop();
            }if(st2.isEmpty()){
                psl[i]=-1;
            }else{
                psl[i]=st2.peek();
            }
            st2.push(i);

        }
        int mod=(int)1e9+7;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            int left=i-psl[i];
            int right=nsr[i]-i;
           
            long freq=(long) left * right;
            long con=(freq*arr[i])%mod;
            sum=((int)(sum+con)%mod);

        }
        return sum;
    }
}