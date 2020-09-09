import queens.*;
public class Queens
{
    public static int numSoluzioni (int n) {
        return numCompletamenti (new Board(n));
    }
    
    private static int numCompletamenti (Board b) {
        int n = b.size();
        int q = b.queensOn();
        if (q == n) {
            return 1;
        } else {
            int i = q + 1;
            int count = 0;
            for (int j = 1; j<=n; j++) {
                if (!b.underAttack(i, j)) {
                    count = count + numCompletamenti(b.addQueen(i, j));
                }
            }
            return count;
        }
    }
    
    public static final SList<Board> NULL_BOARDLIST = new SList<Board>();
    
    public static SList<Board> listaSoluzioni (int n) {
        return listaCompletamenti(new Board(n));
    }
    
    private static SList<Board> listaCompletamenti (Board b) {
        int n = b.size();
        int q = b.queensOn();
        if (q == n) {
            return new SList<Board>().cons(b);
        } else {
            int i = q + 1;
            SList<Board> sol =new SList<>();
            for (int j = 1; j <= n; j++) {
                if (!b.underAttack(i, j)) {
                    sol = sol.append( listaCompletamenti( b.addQueen(i, j) ));
                }
            }
            return sol;
        }
    }
    
    public static ChessboardView scacchiera (int n) {
        SList<Board> b = listaSoluzioni(n);
        ChessboardView gui = new ChessboardView (b.listRef(0).size());
        for (int i=0; i<b.length(); i++) {
            gui.setQueens(b.listRef(i).arrangement());
        }
        return gui;
    }
    
        
    
    
} // class Queens
