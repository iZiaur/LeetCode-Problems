class Solution {
    public boolean isValid(String s) {
        boolean valid=true;
        if(s.length()<2) return false;
        Stack <Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                if((st.peek()=='(' && ch==')')||(st.peek()=='{' && ch=='}')
                ||(st.peek()=='[' && ch==']')){
                    st.pop();
                }else{
                    return false;
                }
            }
            }
        if(!st.isEmpty()){
            System.out.print(st.peek());
            return false;
        }
        return true;
        }
    }