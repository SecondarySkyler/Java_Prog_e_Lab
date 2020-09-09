public class Node implements Comparable<Node> {
    
    private final char character;
    private final int weight;
    private final Node left;    
    private final Node right;
    
    public Node (char c, int w){
        character = c;
        weight = w;
        left = null;
        right = null;
    }
    
    public Node (Node l, Node r) {
        character = (char) 0;
        weight = l.weight() + r.weight();
        left = l;
        right = r;
    }
    
    public boolean isLeaf() {
        return (left == null);
    }
    
    public char character() {
        return character;
    }
    	
    public int weight() {
    	return weight;
    }
	
    public Node left() {
    	return left;
    }
	
    public Node right() {
    	return right;
    }
	
    public int compareTo(Node n) {
    	if (weight < n.weight()) {
    		return -1;
    	} else if (weight == n.weight()) {
    		return 0;
    	} else {
    		return 1;
    	}
    }
}
