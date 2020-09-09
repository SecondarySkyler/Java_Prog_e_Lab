public class IntSList
{
    // Costante lista vuota
    public static final IntSList NULL_INTLIST = new IntSList();
    
    private boolean empty;
    private int first;
    private IntSList resto;
    
    public IntSList() {  //creazione di una lista vuota
	empty = true;
	first = 0;
	resto = null;
    }
    
    public IntSList (int f, IntSList r) {
        empty = false;
        first = f;
        resto = r;
    }
    
   public boolean isNull() {
	return empty;
   }
	
   public int car() {
	return first;
   }
   
   public IntSList cdr() {
       return resto;
   }
    
   public IntSList cons(int n) {
       return new IntSList(n, this);
   }
   
   public String toString() {               
	 if ( empty ) {
		 return "()";
	 } else if ( resto.isNull() ) {
		 return "(" + first + ")";
	 } else {
		 String rep = "(" + first;
		 IntSList r = resto;
		 while ( !r.isNull() ) {
			 rep = rep + ", " + r.car();
			 r = r.cdr();
		 }
		 return ( rep + ")" );
		 }
	}
   public int length ( ) {
	if (this.isNull()) {
		return 0;
	} else {
	    return this.cdr().length() + 1;
	}
		
   }
   public int listRef (int i) {
	if (i == 0) {
		return car();
	} else {
		return cdr().listRef(i-1);
	}
   }
   public boolean equals (IntSList cl) {
	if (isNull()) {
		return (cl.isNull());
	} else if (cl.isNull()) {
		return false;
	} else if (car() == cl.car()) {
		return (cdr().equals(cl.cdr()));
	} else {
		return false;
	}
   }
   public IntSList append (IntSList ql) {
	if (isNull()) {
		return ql;
	} else {
		return cdr().append(ql).cons(car());
	}
   }
   public IntSList reverse() {
	return reverseRec (NULL_INTLIST);
   }
   private IntSList reverseRec(IntSList rl) {
	if (isNull()) {
		return rl;
	} else {
		return cdr().reverseRec(rl.cons(car()));
	}
   }
       
    
    
    
    
    
} // class IntSList
