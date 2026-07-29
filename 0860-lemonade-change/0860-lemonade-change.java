class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Arrays.sort(bills);

        int count5=0;
        int count10=0;

        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                count5++;
            }
            if(bills[i]==10){
                if(count5==0){
                    return false;
                }
                count10++;
                count5--;
            }
            if(bills[i]==20){
                if(count10==0 && count5>=3){
                    count5=count5-3;
                    System.out.print("Count 5 has became  "+count5);
                }
                
                else if(count10>0 && count5>0){
                count10--;
                count5--;
                }else{
                    return false;
                }
                
            }
        }

        return true;

    }
}