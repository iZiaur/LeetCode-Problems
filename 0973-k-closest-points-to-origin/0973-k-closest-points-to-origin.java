class Solution {

    public class Point implements Comparable<Point>{
        int x;
        int y;
        int dist;
        public Point(int x,int y,int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
        public int compareTo(Point p1){
            return this.dist-p1.dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Point> pq=new PriorityQueue<>();

        for(int i=0;i<points.length;i++){
            int distance=(points[i][0]*points[i][0])+(points[i][1]*points[i][1]);
           
            pq.add(new Point(points[i][0],points[i][1],distance));
            
        }
        int sol[][]=new int[k][2];
        
        for(int i=0;i<k;i++){
            Point current= pq.poll();
            sol[i]=new int[]{current.x,current.y};
           
        }
        return sol;
        
    }
}