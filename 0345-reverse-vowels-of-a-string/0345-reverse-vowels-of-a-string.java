class Solution {
    public String reverseVowels(String s) {
        StringBuilder vowels=new StringBuilder();
        ArrayList<Integer> index=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'||s.charAt(i)=='A'||s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U'){
                vowels.append(s.charAt(i));
                index.add(i);
            }
        }


        vowels.reverse();
        StringBuilder finals=new StringBuilder(s);
        for(int i=0;i<index.size();i++){
            finals.setCharAt(index.get(i),vowels.charAt(i));
        }

        return finals.toString();
    }
}
