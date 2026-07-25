class Solution {
    public int maxProduct(int n) {
        ArrayList<Integer> arr=new ArrayList<>();
        int temp=n;

        while(temp>0){
            int digit=temp%10;
            arr.add(digit);
            temp=temp/10;
        }

        Collections.sort(arr);
        int max=arr.get(arr.size()-1)*arr.get(arr.size()-2);
        return max;

    }
}