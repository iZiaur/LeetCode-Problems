class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map=new HashMap<>();
        for(int i=0;i<knowledge.size();i++){
            List<String> temp=knowledge.get(i);
            map.put(temp.get(0),temp.get(1));
        }
        StringBuilder str=new StringBuilder(s);
        
        for(int i=0;i<str.length();i++){

            if(str.charAt(i)=='('){

                int closingindex=-1;
                for(int j=i;j<str.length();j++){
                    if(str.charAt(j)==')'){
                         closingindex=j;
                        break;
                    }

                }
                String search=str.substring(i+1,closingindex);
                String res="?";
                if(map.containsKey(search)){
                    res=map.get(search);
                }
                str.replace(i,closingindex+1,res);
                System.out.println(search);
                System.out.println(res);
            }
        }

        return str.toString();
    }
}