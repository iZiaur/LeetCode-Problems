class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        ArrayList<Integer> sol=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String str=words[i];
            int sum=0;
            for(int j=0;j<str.length();j++){
                char ch=str.charAt(j);
                sum+=weights[ch-'a'];
            }
            sum=sum%26;
            sol.add(sum);
        }
       

        ArrayList<Character> chh=new ArrayList<>();
        char first='a';
        chh.add(first);
        for(int i=1;i<26;i++){
            chh.add(++first);
        }
        Collections.reverse(chh);
        // for(int i=0;i<26;i++){
        //     System.out.println(chh.get(i));
        // }
        StringBuilder str=new StringBuilder();
        for(int i=0;i<sol.size();i++){
            str.append(chh.get(sol.get(i)));
        }
        

        return str.toString();
    }
}