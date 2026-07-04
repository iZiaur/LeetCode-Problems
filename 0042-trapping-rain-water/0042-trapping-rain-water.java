class Solution {
    public int trap(int[] height) {
    int [] nextright=new int[height.length];
    int nextleft[]=new int[height.length];
    nextright[nextright.length-1]=0;
    int maxright=height[height.length-1];

    for(int i=height.length-2;i>=0;i--){
        nextright[i]=maxright;
        maxright=Math.max(maxright,height[i]);
    }

    
    nextleft[0]=0;
    int maxleft=height[0];

    for(int i=1;i<height.length;i++){
        nextleft[i]=maxleft;
        maxleft=Math.max(maxleft,height[i]);
    }
    
    int water=0;
    for(int i=0;i<height.length;i++){
        if(height[i]<=nextleft[i] && height[i]<=nextright[i]){
            water+=Math.min(nextright[i],nextleft[i])-height[i];
        }
    }
     return water;
    }
}