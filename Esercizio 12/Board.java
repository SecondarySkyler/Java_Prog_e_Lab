import java.util.function.*;
public class Board
{
    private static final String ROWS = " 123456789ABCDEF";
    private static final String COLS = " abcdefghijklmno";

    private final int size;
    private final int queens;   
    private final SList<Integer> row;
    private final SList<Integer> col;
    private final SList<Integer> diag1;
    private final SList<Integer> diag2;
    
    private final String config;
    
    public Board (int n) {
        size = n;
        queens = 0;
        row = new SList<Integer>();
        col = new SList<Integer>();
        diag1 = new SList<Integer>();
        diag2 = new SList<Integer>();
        config = "";
    }
    
    private Board (int n, int q, SList<Integer> r, SList<Integer> c, SList<Integer> dg1, SList<Integer> dg2, String conf ) {
        size = n;
        queens = q;
        row = r;
        col = c;
        diag1 = dg1;
        diag2 = dg2;
        config = conf;
    }
    
    public int size() {
    return size;
    }
    
    public int queensOn() {
    return queens;
    }
    
    public boolean underAttack (int i, int j) {
        return (!row.isNull() && (
                underAttackRec(row, i) ||
                underAttackRec(col, j) ||
                underAttackRec(diag1, i-j) ||
                underAttackRec(diag2, i+j)));
    }
    private boolean underAttackRec (SList<Integer> sl, int n) {
        boolean found = false;
        for (int i = 0; i < sl.length(); i++) {
            found = found || (sl.listRef(i) == n);
        }
        return found;
    }
    
    public String arrangement() {
    return config;
    }
    
    public Board addQueen (int i, int j) {
        SList<Integer> r = new SList<Integer>(i, new SList<Integer>());
        SList<Integer> c = new SList<Integer>(j, new SList<Integer>());
        SList<Integer> dg1 = new SList<Integer>(i-j, new SList<Integer>());
        SList<Integer> dg2 = new SList<Integer>(i+j, new SList<Integer>());
        return new Board (size, queens + 1, row.append(r), col.append(c), diag1.append(dg1), diag2.append(dg2),
                            config + " " + COLS.substring(j, j + 1) + ROWS.substring(i, i + 1) + " ");
    }
        
} //class Board
