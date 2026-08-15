class Solution {
    public int findComplement(int num) {
        StringBuilder str=new StringBuilder(Integer.toBinaryString(num));
        System.out.println(str);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0'){
                str.setCharAt(i,'1');
            }else if(str.charAt(i)=='1'){
                str.setCharAt(i,'0');
            }
        }

        return Integer.parseInt(str.toString(),2);
    }
}