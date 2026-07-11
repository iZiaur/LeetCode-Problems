class Solution {
    public int characterReplacement(String s, int k) {
       int maxlen=0;
       int l=0;
       int r=0;
       int hash[]=new int[26];
       int maxfreq=0;
       while(r<s.length()){
        hash[s.charAt(r)-'A']++;
        maxfreq=Math.max(maxfreq, hash[s.charAt(r)-'A']);
        if((r-l+1)-maxfreq>k){
             hash[s.charAt(l)-'A']--;
            
             l++;
        }

        if((r-l+1)-maxfreq<=k){
            maxlen=Math.max(maxlen,r-l+1);
        }
        r++;

       }
       return maxlen;
}
}