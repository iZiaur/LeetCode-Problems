class Solution {
    public String reverseParentheses(String s) {
        StringBuilder str=new StringBuilder();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                List<Character>temp=new ArrayList<>();
                while(!st.isEmpty() && st.peek()!='('){
                    temp.add(st.pop());
                }
                if(!st.isEmpty()){
                    st.pop();
                }

                for(char c:temp){
                    st.push(c);
                }
               
            }else{
                 st.push(s.charAt(i)); 
            }
           }

           while(!st.isEmpty()) str.append(st.pop());
           str.reverse();
         return str.toString();
           
        }
        
    }
