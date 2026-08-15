class Solution {
    class Word{
        String s;
        int len;

        public Word(String s,int len){
            this.s=s;
            this.len=len;
        }
    }
    public String sortSentence(String s) {
        PriorityQueue<Word> pq=new PriorityQueue<>((a,b)->a.len-b.len);

        String [] arr=s.split("\\s+");

        for(int i=0;i<arr.length;i++){
            String s1=arr[i];
            int len=s1.length();

            int lastlen=s1.charAt(s1.length()-1)-'0';
            
            pq.add(new Word(s1.substring(0,s1.length()-1),lastlen));
        }

        StringBuilder str=new StringBuilder();
        while(!pq.isEmpty()){
            Word w1=pq.poll();
            str.append(w1.s);
            str.append(" ");
        }

        return str.toString().trim();
    }
}