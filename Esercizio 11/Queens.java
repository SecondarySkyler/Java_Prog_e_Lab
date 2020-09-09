
public class Queens {
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
	    for (int j = 1; j <= n; j++) {
	        if (!b.underAttack(i, j)) {
	            count = count + numCompletamenti( b.addQueen(i, j) );
		}
            }
            return count;
        }
    }
}//class Queens
