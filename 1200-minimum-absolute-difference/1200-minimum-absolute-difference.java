class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int arrl[][]=new int[arr.length-1][3];
        for(int i=0;i<arr.length-1;i++){
            arrl[i][0]=arr[i+1]-arr[i];
            arrl[i][1]=arr[i];
            
            arrl[i][2]=arr[i+1];
            
        }
        Arrays.sort(arrl,Comparator.comparingInt(o->o[0]));
        List<List<Integer>> sol=new ArrayList<>();
        List <Integer> temp=new ArrayList<>();
        temp.add(arrl[0][1]);
        temp.add(arrl[0][2]);
        sol.add(temp);
        for(int i=1;i<arrl.length;i++){
            if(arrl[i][0]>arrl[0][0]){
                break;
            }else if(arrl[i][0]==arrl[0][0]){
                List <Integer> tempu=new ArrayList<>(); 
                tempu.add(arrl[i][1]);
                tempu.add(arrl[i][2]);
                sol.add(tempu);
            }
        }
        return sol;
    }
}