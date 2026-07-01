class MyStack {
    Queue <Integer> q;
    public MyStack() {
        q=new ArrayDeque<>();
    }
    
    public void push(int x) {
        int n=q.size();
        q.add(x);
        for(int i=0;i<n;i++){
            q.add(q.peek());
            q.remove();
        }
    }
    
    public int pop() {
        int top=q.peek();
        q.remove();
        return top;
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        if(q.isEmpty()){
            return true;
        }else{
             return false;
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */