class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder str=new StringBuilder();
            for(int i=0;i<s.length();i=i+k){
                int sum=0;
                for(int j=i;j<s.length() && j<i+k;j++){
                    sum+=s.charAt(j)-'0';
                    // System.out.println(sum);
                }
                str.append(sum);

            }
            System.out.println(str);
            s=str.toString();
        }

        return s;
    }
}