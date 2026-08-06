class Solution {

    public static int product(int n){
        StringBuilder str=new StringBuilder(String.valueOf(n));
        int product=1;

        for(int i=0;i<str.length();i++){
            int digit=str.charAt(i)-'0';
            product*=digit;
        }
        return product;
    }
    public int smallestNumber(int n, int t) {
        //  System.out.println(product(25));
        while(true){
            int productofdigit=product(n);
            // System.out.println(productofdigit);
            if(productofdigit%t==0){
                return n;
            }
            n=n+1;
            // System.out.println("New Number "+n);
        }
       
    }
}