class Solution {
    public String capitalizeTitle(String title) {
        String arr[]=title.split(" ");
        StringBuilder str=new StringBuilder();

        for(int i=0;i<arr.length;i++){
            String s=arr[i];
            if(s.length()<=2){
                s=s.toLowerCase();
            }
            else{
                s=Character.toUpperCase(s.charAt(0))+ s.substring(1).toLowerCase();
            }

            str.append(s);
            str.append(" ");
        }


        return str.toString().trim();
    }
}