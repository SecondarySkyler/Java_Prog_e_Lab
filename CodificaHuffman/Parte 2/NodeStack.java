public class NodeStack {
    private static final int DIM = 127;
    int size;
    Node[] a;
    
    public NodeStack() {
        this.a = new Node[DIM];
        this.size = 0;
    }
    
    public boolean empty() {
        return (size == 0);
    }
    
    public Node peek() {
        return a[0];
    }
    
    public Node pop() {
        size--;
        return a[size];
    }
    
    public void push (Node n) {
        a[size] = n;
        size++;
    }
   

}
