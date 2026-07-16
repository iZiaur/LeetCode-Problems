class MedianFinder {
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer>  minheap;

    public MedianFinder() {
        maxheap=new PriorityQueue<>(Collections.reverseOrder());
        minheap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxheap.add(num);

        if(!maxheap.isEmpty() && !minheap.isEmpty() && maxheap.peek()>minheap.peek()){
            minheap.add(maxheap.poll());
        }
        if(maxheap.size()>minheap.size()+1){
             minheap.add(maxheap.poll());
        }
        if(minheap.size()>maxheap.size()){
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        int len=minheap.size()+maxheap.size();
        if(len%2!=0){
            return (double) maxheap.peek();
        }else{
            double median=(maxheap.peek()+minheap.peek())/(double) 2;
            return median;
        }
       
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */