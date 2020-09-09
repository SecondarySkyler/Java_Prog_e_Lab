import java.util.Arrays;
public class longestSub
{
    //PARTE 1
    public static final int UNKNOWN = 0;
    public static int lisMemoization (int[] s) {
        int n = s.length;
        int [][] h = new int [n+1][n+1];
        int [] b = Arrays.copyOf(s, n+1);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) { 
                h[i][j] = UNKNOWN;
            }
        }
        return lisMem(b, 0, n, h);
    }
    private static int lisMem ( int[] s, int i, int j, int[][] h) {
        final int n = s.length - 1;
        int t = s[j];
        
        if (i == n) {
            h[i][j] = 0;
        }
        else if (s[i] <= t) {
            h[i][j] = lisMem(s, i+1, j, h);
        }
        else {
            h[i][j] = Math.max(1 + lisMem(s, i+1, i, h), lisMem(s, i+1, j, h));
        }
        return h[i][j];
    }
    
    
    //PARTE II
    public static IntSList lis(int[] s) {
        final int n = s.length;
        IntSList [][] h = new IntSList [n+1][n+1];
        int [] b = Arrays.copyOf(s, n+1);
        
        for (int i=0; i <= n; i++) {
            for (int j=0; j <= n; j++) {
                h[i][j] = new IntSList();
            }
        }
        
        
        return lisRec(b, 0 , n, h);
    }
    private static IntSList lisRec(int[] s, int i, int j, IntSList[][] h) {
        int n = s.length - 1;
        int t = s[j];
        
        if (i == n) {
            h[i][j] = new IntSList();
        }
        else if (s[i] <= t) {
            h[i][j] = lisRec (s, i+1, j, h);
        }
        else {
            h[i][j] = better ( lisRec(s, i+1, i, h).cons(s[i]), lisRec(s, i+1, j, h));
        }
        return h[i][j];
    }
    private static IntSList better (IntSList s, IntSList e) {
        int n = s.length();
        int m = e.length();
        
        if (n < m) {
            return e;
        }
        else if (n > m) {
            return s;
        }
        else if (Math.random() < 0.5) {
            return e;
        }
        else {
            return s;
        }
    }
    
    public static void components (int[] sup) {
        final int n = sup.length - 1;
        int[][] h = new int[n + 1][n+ 1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                h[i][j] = UNKNOWN;
            }
        }
        
        int aux = lisMem(sup, 0, n, h);
        final int totalComp = (n + 1) ^ 2;
        int allocated = 0;
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if ( !(h[i][j] == UNKNOWN))
                allocated++;
            }
        }
        System.out.println("Componenti inutilizzate: " + (totalComp - allocated));
    }
}
