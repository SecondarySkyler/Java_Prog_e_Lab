import puzzleboard.PuzzleBoard;
/**
 * Metodo per istanziare un modella della tavoletta
 * Metodo isSorted per verificare se i tasselli sono ordinati
 * Metodo isMoveable per verificare se un dato tassello può essere mosso
 * Metodo per la forma testuale (stringa)
 * Metodo per spostare
 */

public class puzzleBoard {
    private int size;
    private int board[][];
    private final int celle;
    private static final int BLANK = 0;
    
    public puzzleBoard(int n) {
        this.size = n;
        this.board = new int [n][n];
        this.celle = n * n;
        int t = 0;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                t = (t + 1) % celle;
                board[i][j] = t;
            }
        }
        random();
    }
    
    private void random() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                int i1 = (int) (Math.random() * size);
                int j1 = (int) (Math.random() * size);
                
                int temp = board[i][j];
                board[i][j] = board[i1][j1];
                board[i1][j1] = temp;
            }
        }
    }
    
    public boolean isOrdered(){
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
               if (board[i][j] > board[i][j + 1]) {
                   if (board[i][j] > board[i + 1][j]) {
                       return false;
                    }
                }   
            }  
        }
         return true;
    }
    
    private int[] getCoord(int tass) {
        int[] coord = new int[2];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] == tass) {
                    coord[0] = i;
                    coord[1] = j;
                }
            }
        }
        return coord;
    }
    private int[] getCoordBlank() {
        int[] coord = new int[2];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] == BLANK) {
                    coord[0] = i;
                    coord[1] = j;
                }
            }
        }
        return coord;
    }
    
    public boolean isMoveable(int tass) {
        int[] u = getCoord(tass);
        int[] v = getCoordBlank();
        if ( (tass > 0) && (tass < celle)) {
            int diffX = Math.abs(u[0] - v[0]);
            int diffY = Math.abs(u[1] - v[1]);
            
            return (diffX + diffY == 1);
        }
        return false;
    }
    
    public void move(int tass) {
        int[] u = getCoord(tass);
        int[] v = getCoordBlank();
        int u1 = u[0];
        int u2 = u[1];
        int v1 = v[0];
        int v2 = v[1];
        if(isMoveable(tass)) {
            board[u1][u2] = BLANK;
            board[v1][v2] = tass;
            u[0] = v1;
            u[1] = v2;
            v[0] = u1;
            v[1] = u2;
        }
    }
            
       
    public String toString() {
        String str = "";
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                str = str + board[i][j] + " ";
            }
            str = str + "\n";
        }
        return str;    
    }
 /**
  *  PARTE 2
  */   
    public PuzzleBoard display () {
        PuzzleBoard guiBoard = new PuzzleBoard(size);
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] != BLANK) {
                    guiBoard.setNumber(i + 1, j + 1, board[i][j]);
                }
            }
        }
        return guiBoard;
    }
    public void moveGui(int tass, PuzzleBoard display) {
        int[] u = getCoord(tass);
        int[] v = getCoordBlank();
        int i = u[0];
        int j = u[1];
        int i1 = v[0];
        int j2 = v[1];
        
        if( (Math.abs(i - i1) + Math.abs(j - j2)) == 1) {
            board[i1][j2] = tass;
            board[i][j] = BLANK;
            u[0] = i1;
            u[1] = j2;
            v[0] = i;
            u[1] = j;
            
            if(display != null) {
                display.clear(i + 1, j + 1);
                display.setNumber(i1 + 1, j2 + 1, board[i1][j2]);
            }
        }
    }
     public void game() {
         puzzleBoard board = new puzzleBoard(size);
         PuzzleBoard v = board.display();
         v.display();
         while (!board.isOrdered()) {
             int p = v.get();
             board.moveGui(p, v);
             v.display();
            }
         
        }
    
} // class PuzzleBoard
