class Solution {
    public static int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> st=new Stack<>();

        int ngr[]=new int[n];

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ngr[i]=n;
            }else{
                ngr[i]=st.peek();
            }
            st.push(i);
        }
        int ngl[]=new int[n];
        st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ngl[i]=-1;
            }else{
                ngl[i]=st.peek();
            }
            st.push(i);
        }
        int maxarea=0;
        for(int i=0;i<n;i++){
            int width=ngr[i]-ngl[i]-1;
            int area=heights[i]*width;
            maxarea=Math.max(maxarea,area);
        }
        return maxarea;

    }
    public int maximalRectangle(char[][] matrix) {
        int max=0;
        int heights[]=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    heights[j]++;
                }else{
                    heights[j]=0;
                }
            }
            int area=largestRectangleArea(heights);
            max=Math.max(max,area);
        }
        return max;   
    }
}