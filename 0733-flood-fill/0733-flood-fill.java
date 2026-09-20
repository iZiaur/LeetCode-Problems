class Solution {
    public void helper(int[][] image,boolean visited[][],int sr, int sc, int color,int orignalcolor){
        if(sc<0 || sr<0 || sc>=image[0].length || sr>=image.length||visited[sr][sc]||image[sr][sc]!=orignalcolor){
            return;
        }
        visited[sr][sc]=true;
        image[sr][sc]=color;
        helper(image,visited,sr,sc-1,color,orignalcolor);
        helper(image,visited,sr,sc+1,color,orignalcolor);
        helper(image,visited,sr-1,sc,color,orignalcolor);
        helper(image,visited,sr+1,sc,color,orignalcolor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orignalcolor=image[sr][sc];
        boolean visited[][]=new boolean[image.length][image[0].length];

        helper(image,visited,sr,sc,color,orignalcolor);

        return image;
    }
}