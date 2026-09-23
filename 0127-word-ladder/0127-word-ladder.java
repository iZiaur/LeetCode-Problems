class Solution {
    class Pair{
        String word;
        int steps;

        public Pair(String word,int steps){
            this.word=word;
            this.steps=steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        HashSet<String>set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair p=q.poll();
            String word=p.word;
            if(word.equals(endWord)){
                return p.steps;
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char [] wordarr=word.toCharArray();
                    wordarr[i]=ch;
                    String newstr=new String(wordarr);
                    if(set.contains(newstr)){
                        set.remove(newstr);
                        q.add(new Pair(newstr,p.steps+1));
                    }
                }
            }
        }

        return 0;
        
    }
}