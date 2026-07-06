class Solution {
    public String removeKdigits(String num, int k) {
        // if(num.length()==k){
        //     return "0";
        // }
        Stack<Integer> st=new Stack<>();
        StringBuilder str=new StringBuilder();
        for(int i=0;i<num.length();i++){
            int el=num.charAt(i)-'0';
            System.out.println(el);
            while(!st.isEmpty() && st.peek()>el && k>0){
                st.pop();
                k--;
            }
            st.push(el);
        }
        while(k>0){
            st.pop();
            k--;
        }
        if(st.isEmpty()){
            return "0";
        }
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        str.reverse();
        int startingindex=-1;
        for(int i=0;i<str.length();i++){
            int el=str.charAt(i)-'0';
            if(el>0){
                startingindex=i;
                break;
            }
        }

        boolean allzero=true;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='0'){
                allzero=false;
                break;
            }
        }
        if(allzero){
            return "0";
        }

        StringBuilder ans=new StringBuilder();
        if(startingindex!=-1){
            for(int i=startingindex;i<str.length();i++){
                ans.append(str.charAt(i));

            }
            return ans.toString();
        }
        
    
        return str.toString();
    }
}