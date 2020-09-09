public class Board {
    
    private static final String ROWS = " 123456789ABCDEF";
    private static final String COLS = " abcdefghijklmno";
    
    private final int size;
    private final int queens;   
    private final IntSList righe;
    private final IntSList colonne;
    private final IntSList dx;
    private final IntSList sx;
    private final String config;
    
    public Board (int n) {
        size = n;
        queens = 0;
        righe = new IntSList();
        colonne = new IntSList();
        dx = new IntSList();
        sx = new IntSList();
        config = "";   
    }
    
    private Board (int n, int q, IntSList r, IntSList col, IntSList ddx, IntSList dsx, String c) {
        size = n;
        queens = q;
        righe = r;
        colonne = col;
        dx = ddx;
        sx = dsx;
        config = c;   
    } 
    
    public int size() {
        return size;
    }
    
    public int queensOn() {
        return queens;
    }
    
    public boolean underAttack(int i, int j) {
        return (!righe.isNull() && 
                (underAttackRec(righe, i) ||
                underAttackRec(colonne, j) ||
                underAttackRec(dx, i-j) ||
                underAttackRec(sx, i+j)));
    }
    
    private boolean underAttackRec (IntSList sl, int n) {
        boolean found = false;
        for (int i=0; i<sl.length(); i++) {
            found = found || (sl.listRef(i) == n);
        }
        return found;
    }
    
    public Board addQueen(int i, int j) {
        IntSList r = new IntSList (i, new IntSList());
        IntSList col = new IntSList (j, new IntSList());
        IntSList ddx = new IntSList (i-j, new IntSList());
        IntSList dsx = new IntSList (i+j, new IntSList());
        return new Board (size, queens+1, righe.append(r), colonne.append(col), dx.append(ddx), sx.append(dsx),
                            config + " " + COLS.substring(j, j+1)
                                            + ROWS.substring(i, i+1) + " ");
    }
        
    
    public String arrangement() {
        return config;
    }
            
    
}// class Board
