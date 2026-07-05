class Solution {
    public int[] asteroidCollision(int[] arr) {
      Stack <Integer> st=new Stack<>();
      for(int i=0;i<arr.length;i++){
        if(arr[i]>0){
            st.push(arr[i]);
        }
        else{
            while(!st.isEmpty() && st.peek()>0 && st.peek()<-arr[i]){
            st.pop();
        }if(!st.isEmpty() && st.peek()==-arr[i]){
            st.pop();
        }
        else if(st.isEmpty() || st.peek()<0){
            st.push(arr[i]);
        }
        }
        
    }

    ArrayList<Integer> arrl=new ArrayList<>();
    while(!st.isEmpty()){
        arrl.add(st.pop());
    }
    Collections.reverse(arrl);
    int ans[]=new int[arrl.size()];
    for(int i=0;i<arrl.size();i++){
        ans[i]=arrl.get(i);
    }
    return ans;
}
}